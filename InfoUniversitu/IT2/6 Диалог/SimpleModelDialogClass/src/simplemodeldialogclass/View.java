/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodeldialogclass;

import java.time.format.DateTimeFormatter;
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
    private Label drinkVol;
    private Text nameOrg;
    private Text holidayOrg;

    private void createPane() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        nameOrg = new Text(org.getName());
        nameOrg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(nameOrg, HPos.CENTER);
        grid.add(nameOrg, 0, 0, 2, 1);

        holidayOrg = new Text(org.getHoliday() + " - " + org.getDate().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
        holidayOrg.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(holidayOrg, 0, 1, 2, 1);

        Text drinkVolumeTitle = new Text("Drunk by one person");
        drinkVolumeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(drinkVolumeTitle, 0, 2);

        drinkVol = new Label(Double.toString(org.getDrunkPerPerson()));
        drinkVol.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(drinkVol, 1, 2);
    }

    public void setOrganization(Organization org) {
        this.org = org;
        dataChanged();
    }

    public View(Organization org) { 
        this.org = org;
        createPane();
        this.getChildren().add(grid);
    }

    public void dataChanged() {
        nameOrg.setText(org.getName());
        holidayOrg.setText(org.getHoliday() + " - " + org.getDate().format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
        drinkVol.setText(Double.toString(org.getDrunkPerPerson()));
    }
}