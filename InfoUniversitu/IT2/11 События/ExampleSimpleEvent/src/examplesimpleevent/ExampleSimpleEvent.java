/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplesimpleevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class ExampleSimpleEvent extends Application {

    @Override
    public void start(Stage primaryStage) {

        TextField textBox = new TextField();
        textBox.setPrefSize(200, 100);
        textBox.setPromptText("Write here");

        textBox.setOnKeyPressed((KeyEvent ke) -> {
            System.out.println("Key Pressed: " + ke.getText());
            if (ke.getText().equals("a") && ke.isAltDown()) {
                textBox.setFont(Font.font("Arial", 30));
            }
            if (ke.getCode() == KeyCode.T && ke.isAltDown()) {
                textBox.setFont(Font.font("Times New Roman", 20));
            }
        });

        textBox.setOnKeyReleased((KeyEvent ke) -> {
            System.out.println("Key Released: " + ke.getText());
        });

        double radius = 100;

        Circle circle = new Circle(radius, Color.RED);
        circle.setFocusTraversable(true);

        circle.setOnMouseEntered((MouseEvent me) -> {
            System.out.println("Mouse entered");
            circle.setFill(Color.AQUA);
            circle.requestFocus();
        });

        circle.setOnMouseExited((MouseEvent me) -> {
            System.out.println("Mouse exited");
            circle.setFill(Color.RED);
            //textBox.requestFocus();
        });

        circle.setOnMousePressed((MouseEvent me) -> {
            System.out.println("Mouse pressed");
            circle.setFill(Color.CORAL);
        });

        circle.setOnMouseMoved((MouseEvent me) -> {
            System.out.println("Mouse moved");
            circle.setFill(Color.GRAY);
        });
        circle.setOnKeyPressed((KeyEvent ke) -> {
            System.out.println("Circle Key Pressed: " + ke.getText());
        });
        Text text = new Text("TEXT");
        text.prefWidth(200);
        text.prefWidth(50);
        text.setFocusTraversable(true);
        text.setOnKeyPressed((KeyEvent ke) -> {
            System.out.println("Label Key Pressed: " + ke.getText());
            if(ke.getText().equals("g")) {
                text.setFill(Color.GREEN);
            }
            if(ke.getCode()==KeyCode.B) {
                text.setFill(Color.BLACK);
            }
        });

        VBox root = new VBox();
        root.setSpacing(10);
//        root.getChildren().addAll(circle);
//        root.getChildren().addAll(circle, textBox);
        root.getChildren().addAll(circle, textBox, text);

        Scene scene = new Scene(root, 250, 400);

        primaryStage.setTitle("Simple event");
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
