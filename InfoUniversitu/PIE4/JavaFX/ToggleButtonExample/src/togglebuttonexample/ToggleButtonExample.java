/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package togglebuttonexample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class ToggleButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("LABEL");
        label.setLayoutX(20);
        label.setLayoutY(20);
        label.setPrefSize(200, 20);
        ToggleButton btn = new ToggleButton();
        btn.setLayoutX(20);
        btn.setLayoutY(250);
        btn.setText("Push!");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (btn.isSelected()) {
                    label.setText("ON");
                    label.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                    label.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
                    System.out.println("YES");
                } else {
                    label.setText("OFF");
                    label.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 40));
                    label.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                    System.out.println("No");
                }
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().add(btn);
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 300);

        primaryStage.setTitle("Hello World!");
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
