/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodeldialogclass;

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
public class SimpleModelDialogClass extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Model Dialog");
        Organization org = new Organization("Vasya","70","50","80");
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        View viewOrg = new View(org);
        root.getChildren().add(viewOrg);
        Button btn = new Button();
        btn.setText("Edit");
        btn.setOnAction((ActionEvent event) -> {
            OrganizationEditDialog orgEditDialog = new OrganizationEditDialog(org, "Edit name");
            if(orgEditDialog.getDialog().showAndWait().isPresent())
                viewOrg.dataChanged();
        });
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 900, 400);
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
