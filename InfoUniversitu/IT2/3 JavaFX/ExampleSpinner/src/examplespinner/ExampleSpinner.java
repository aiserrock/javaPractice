/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplespinner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Spinner;
import javafx.scene.layout.VBox;

/**
 *
 * @author nadezhda
 */
public class ExampleSpinner extends Application {

    @Override
    public void start(Stage primaryStage) {
        Spinner<Integer> spInt = new Spinner(-100, 100, 0);
        spInt.setEditable(true);
        Spinner<Double> spDouble = new Spinner(-100.0, 100.0, 1.0, 0.1);
        spDouble.setEditable(true);
        Button btn = new Button();
        btn.setText("Ok");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println(spInt.getValue());
        });

        VBox root = new VBox();
        root.getChildren().add(spDouble);
        root.getChildren().add(spInt);
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Example Spinner");
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
