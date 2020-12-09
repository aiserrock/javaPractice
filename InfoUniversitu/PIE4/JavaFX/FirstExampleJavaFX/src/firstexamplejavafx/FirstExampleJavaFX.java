/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstexamplejavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class FirstExampleJavaFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("First example");
        
        Label labels [] = new Label[10];
                
        FlowPane root = new FlowPane();
                
        for(int i=0; i<10;i++) {
            labels[i] = new Label("This is label " + Integer.toString(i));
        root.getChildren().add(labels[i]);
        }
        
        root.getChildren().remove(labels[3]);
        
        Scene scene = new Scene(root, 100, 100);
        
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
