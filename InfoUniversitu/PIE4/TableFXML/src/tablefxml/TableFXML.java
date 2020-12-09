/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablefxml;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class TableFXML extends Application {

    private ObservableList<Organization> data
            = FXCollections.observableArrayList(
                    new Organization("Kalipso", "Smith", 1200),
                    new Organization("DoggyStyle", "Johnson", 150),
                    new Organization("Galaxy", "Williams", 25),
                    new Organization("Bubble", "Jones", 0),
                    new Organization("Kangaroo", "Brown", 560));

    public ObservableList<Organization> getData() {
        return data;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TableFXML.class.getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        FXMLDocumentController controller = loader.getController();
        controller.setMainApp(this);
        Scene scene = new Scene(root, 355, 600);
        stage.setTitle("Table");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
