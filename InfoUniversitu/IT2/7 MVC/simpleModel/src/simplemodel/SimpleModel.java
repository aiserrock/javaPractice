/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodel;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class SimpleModel extends Application {
    private GridPane grid;
    private Organization org;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Simple Model");
        org = new Organization("Horns&Hoof",10,"International Women's Day", LocalDate.of(2016, 3, 9),0);        
        createPane();       
        Scene scene = new Scene(grid, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void createPane(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text nameOrg = new Text(org.getName());
        nameOrg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(nameOrg, HPos.CENTER);
        grid.add(nameOrg, 0, 0, 2, 1);
        
        Text holidayOrg = new Text(org.getHoliday()+" - " +org.getDate().toString());
        //Text holidayOrg = new Text(org.getHoliday()+" - " +org.getDate().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
        holidayOrg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(holidayOrg, 0, 1, 2, 1);
        
        Text drinkVolumeTitle = new Text("Drink volume");
        drinkVolumeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(drinkVolumeTitle, 0, 2);
        
        Label drinkVol = new Label(Double.toString(org.getDrinkVolume()));
        drinkVol.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(drinkVol, 1, 2);
        
        Button btn = new Button();
        btn.setText("+");
        btn.setOnAction((ActionEvent event) -> {
            org.increaseDrinkVolume();
            drinkVol.setText(Double.toString(org.getDrinkVolume()));
        });
        grid.add(btn, 1, 3);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
