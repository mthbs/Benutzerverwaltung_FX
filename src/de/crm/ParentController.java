package de.crm;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ParentController {

    protected Stage stage;

    protected String[] kunden_columns = {"Id","Vorname","Nachname","E-Mail","Stadt"};


    protected void getCurrentStage(final ActionEvent e) {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    }

    protected void returnOnMainPage() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Hauptanzeige.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style/root.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
