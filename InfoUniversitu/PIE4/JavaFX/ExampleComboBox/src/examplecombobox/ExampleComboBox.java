/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplecombobox;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class ExampleComboBox extends Application {

    @Override
    public void start(Stage primaryStage) {
        final ComboBox comboBox = new ComboBox();
        comboBox.getItems().addAll(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        );
        comboBox.setValue("Friday");

//        ObservableList<String> options
//                = FXCollections.observableArrayList(
//                        "Monday",
//                        "Tuesday",
//                        "Wednesday",
//                        "Thursday",
//                        "Friday",
//                        "Saturday",
//                        "Sunday"
//                );
//        ComboBox comboBox = new ComboBox(options);

        final Label label = new Label();

        Button btn = new Button();
        btn.setText("Read comboBox");
        btn.setOnAction((ActionEvent event) -> {
            if (comboBox.getValue() != null && !comboBox.getValue().toString().isEmpty()) {
                label.setText("selected: " + comboBox.getValue());
            }
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(5);
        vBox.getChildren().addAll(label, comboBox, btn);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Example ComboBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
