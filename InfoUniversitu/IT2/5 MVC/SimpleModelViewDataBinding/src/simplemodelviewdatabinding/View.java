/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodelviewdatabinding;

import java.time.format.DateTimeFormatter;
import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author nadezhda
 */
public class View extends Group {
    private Organization org;
    private GridPane grid;
    //private Label drinkVol;
        
    private void createPane(){
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text nameOrg = new Text(org.getName());
        nameOrg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        nameOrg.textProperty().bind(org.nameStringProperty());
//        Bindings.bindBidirectional(nameOrg.textProperty(),org.nameStringProperty());
        GridPane.setHalignment(nameOrg, HPos.CENTER);
        grid.add(nameOrg, 0, 0, 2, 1);
        
        Text holidayOrg = new Text(org.getHoliday()+" - " +org.getDate().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
        holidayOrg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(holidayOrg, 0, 1, 2, 1);
        
        Text drinkVolumeTitle = new Text("Drink volume");
        drinkVolumeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(drinkVolumeTitle, 0, 2);
        
        Label drinkVol = new Label();
        drinkVol.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        drinkVol.textProperty().bind(org.drinkVolumeProperty().asString());
        grid.add(drinkVol, 1, 2);
        
    }
    public void setOrganization (Organization org) {
        this.org = org;
    }
    public View(Organization org) {
        setOrganization (org);
        createPane();
        this.getChildren().add(grid);
    }       
}

