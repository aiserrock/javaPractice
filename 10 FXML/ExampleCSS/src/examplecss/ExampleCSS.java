/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplecss;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class ExampleCSS extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label hlabel = new Label("Header");
        hlabel.setStyle("-fx-font-size: 24pt;");

        Rectangle rect = new Rectangle(100, 100);
        rect.setLayoutX(50);
        rect.setLayoutY(50);
        rect.getStyleClass().add("my-rect");

        Button btn1 = new Button("Push Button 1");
        Button btn2 = new Button("Push Button 2");
        btn2.setDisable(true);
        ToggleButton btn3 = new ToggleButton("Toggle Button");
        btn3.setId("text-btn");
        
        Label tlabel = new Label("Text");
        tlabel.setId("text-lbl");
        
        VBox root = new VBox();
        root.getStyleClass().add("vbox");
//        root.setAlignment(Pos.CENTER);
//        root.setSpacing(20);
        root.getChildren().addAll(hlabel, rect, btn1, btn2, btn3, tlabel);

        Scene scene = new Scene(root, 300, 400);
        scene.getStylesheets().add(("styles.css"));
        
//        btn1.getStyleClass().add("button1");
//        btn2.getStyleClass().add("button2");
//        scene.getStylesheets().add(("style2.css"));

        primaryStage.setTitle("Example CSS");
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
