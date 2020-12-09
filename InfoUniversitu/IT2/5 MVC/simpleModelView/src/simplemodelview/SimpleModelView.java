/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodelview;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class SimpleModelView extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Model-View");
        Organization org = new Organization("Horns&Hoof",10,"International Women's Day", LocalDate.of(2016, 3, 9),0);        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        View viewOrg = new View(org);
        root.getChildren().add(viewOrg);
        Button btn = new Button();
        btn.setText("+");
        btn.setOnAction((ActionEvent event) -> {
            org.increaseDrinkVolume();
            viewOrg.setInform();
        });
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 500, 300);
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
