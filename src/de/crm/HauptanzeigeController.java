package de.crm;

import de.crm.database.DBConnection;
import de.crm.entity.Kunde;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class HauptanzeigeController extends ParentController implements Initializable {

    @FXML
    private TableView<Kunde> tabelle;
    @FXML
    private TableColumn<Kunde, String> id;
    @FXML
    private TableColumn<Kunde, String> vorname;
    @FXML
    private TableColumn<Kunde, String> name;
    @FXML
    private TableColumn<Kunde, String> email;
    @FXML
    private TableColumn<Kunde, String> stadt;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<Kunde,String>("id"));
        vorname.setCellValueFactory(new PropertyValueFactory<Kunde,String>("vorname"));
        name.setCellValueFactory(new PropertyValueFactory<Kunde,String>("name"));
        email.setCellValueFactory(new PropertyValueFactory<Kunde,String>("email"));
        stadt.setCellValueFactory(new PropertyValueFactory<Kunde,String>("stadt"));

        loadKundenList();
    }

    private void loadKundenList() {
        try {
            DBConnection dba = new DBConnection("root","root");
            List<Kunde> kList = dba.createCustomerList();
            tabelle.setItems(FXCollections.observableList(kList));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void btnCancelClicked(ActionEvent e) throws IOException {
        getCurrentStage(e);
        stage.close();
    }

    public void btnAddCustomer(ActionEvent e) throws IOException {
        getCurrentStage(e);
        Parent root = FXMLLoader.load(getClass().getResource("KundeHinzufügen.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style/root.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void btnRemoveCustomer(ActionEvent e) throws IOException {
        getCurrentStage(e);
        Parent root = FXMLLoader.load(getClass().getResource("KundeEntfernen.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style/root.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void btnRefreshClicked(ActionEvent e) throws IOException {
        getCurrentStage(e);
        loadKundenList();
    }
}
