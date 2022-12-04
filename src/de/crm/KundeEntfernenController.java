package de.crm;

import de.crm.database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class KundeEntfernenController extends ParentController implements Initializable {

    @FXML
    private ChoiceBox<String> choice_column;

    @FXML
    private TextField searchfield;

    public void btnAbbrechen(ActionEvent e) throws IOException {
        getCurrentStage(e);
        returnOnMainPage();
    }

    public void btnLöschen(ActionEvent e) throws IOException {
        System.out.println("Btn Prüfen clicked");
        String DBColumn = null;
        boolean forward = true;
        switch (choice_column.getValue()) {
            case "Id":
                DBColumn = "id";
                break;
            case "Vorname":
                DBColumn = "vorname";
                break;
            case "Nachname":
                DBColumn = "name";
                break;
            case "E-Mail":
                DBColumn = "email";
                break;
            case "Stadt":
                DBColumn = "stadt";
                break;
            default:
                forward = false;
                break;
        }
        if (forward) {
            String DBValue = searchfield.getText();
            DBConnection dba = new DBConnection("root", "root");
            dba.deleteCustomer(DBColumn, DBValue);
            getCurrentStage(e);
            returnOnMainPage();

        } else {
            System.out.println("Something went wrong. forward=false");
        }
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        choice_column.getItems().addAll(kunden_columns);
        choice_column.setValue("Id");
    }
}
