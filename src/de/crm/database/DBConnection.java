package de.crm.database;

import de.crm.entity.Kunde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DBConnection {

    private String username;
    private String password;
    private Statement statement;

    public DBConnection(String username, String password){
        this.username = username;
        this.password = password;
        establishConnection();
    }

    private void establishConnection(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/activeworkbench",username,password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<Kunde> createCustomerList() throws SQLException {
        ResultSet resultSet = statement.executeQuery(" select * from kunden");
        List<Kunde> kundenListe = new ArrayList<>();
        while(resultSet.next()){
            Kunde k = new Kunde(resultSet.getString("id"),resultSet.getString("vorname"),resultSet.getString("name"),
                    resultSet.getString("email"),resultSet.getString("stadt"));
            kundenListe.add(k);
        }
        return kundenListe;
    }

    public void addNewCustomer(String vorname, String name, String email){
        String query = "insert into kunden (vorname, name, email) values (\'"+vorname+"\',\'"+name+"\',\'"+email+"\')";
        try{
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void addNewCustomer(String vorname, String name, String email, String stadt){
        String query = "insert into kunden (vorname, name, email, stadt) values (\'"
                +vorname+"\',\'"+name+"\',\'"+email+"\',\'"+stadt+"\')";
        try{
            System.out.println(query);
            statement.executeUpdate(query);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void deleteCustomer(String DBCol, String DBVal) {
        String query = "delete from kunden where "+DBCol+" = \'" + DBVal+ "\'";
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
