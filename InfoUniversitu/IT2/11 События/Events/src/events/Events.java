/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class Events extends Application {

    private int windowWidth = 600;
    private int windowHeight = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple Application");
        primaryStage.setScene(initScene());
        primaryStage.show();
    }

    private Scene initScene() {
        Group root = new Group();
        //root.addEventHandler(KeyEvent.ANY, (KeyEvent e) ->{System.out.println("Key event");});
        Scene myScene = new Scene(root, windowWidth, windowHeight);
        for (int i = 0; i < 5; i++) {
            root.getChildren().add(new MyLabel("Some Text"));
        }
        return myScene;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
