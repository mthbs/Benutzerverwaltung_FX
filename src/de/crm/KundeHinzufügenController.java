package de.crm;

import de.crm.database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;


public class KundeHinzufügenController  extends ParentController {

    @FXML
    private TextField new_vorname;
    @FXML
    private TextField new_name;
    @FXML
    private TextField new_email;
    @FXML
    private TextField new_stadt;
    @FXML
    private Label err_label;

    public void btnAbbrechen(ActionEvent e) throws IOException {
        getCurrentStage(e);
        returnOnMainPage();
    }

    public void btnSpeichern(ActionEvent e) throws IOException {
        getCurrentStage(e);
        if( !(new_vorname.getText().isEmpty() || new_name.getText().isEmpty() || new_email.getText().isEmpty()) ){
            DBConnection dba = new DBConnection("root","root");
            if(!new_stadt.getText().isEmpty()){
                dba.addNewCustomer(new_vorname.getText(),new_name.getText(),new_email.getText(),new_stadt.getText());
            } else {
                dba.addNewCustomer(new_vorname.getText(),new_name.getText(),new_email.getText());
            }
            returnOnMainPage();
        } else {
            err_label.setText("Nicht alle erforderlichen Fenster wurden befüllt");
            err_label.setTextFill(Color.web("#ff0000"));
        }
    }
}
