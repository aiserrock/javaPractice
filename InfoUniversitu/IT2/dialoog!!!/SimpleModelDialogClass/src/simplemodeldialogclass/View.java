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
    private Text nameLabel,statusLabel;
    /*private Text subject1Title;
    private Text subject2Title;
    private Text subject3Title;*/

    private void createPane() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label name = new Label("Name Person");
        name.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(name, 0, 0);

        nameLabel = new Text(org.getName());
        nameLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(nameLabel, HPos.CENTER);
        grid.add(nameLabel, 1, 0, 1, 1);

        Label status = new Label("status");
        status.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(status, 0, 1);

        statusLabel = new Text(org.getStatus());
        statusLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(statusLabel, HPos.CENTER);
        grid.add(statusLabel, 1, 1, 1, 1);


    }

   /* public void setName(Organization org) {
        this.org = org;
        dataChanged();
    }*/

    public View(Organization org) { 
        this.org = org;
        createPane();
        this.getChildren().add(grid);
    }

    public void dataChanged() {
        nameLabel.setText(org.getName());
        statusLabel.setText(org.getStatus());
        /*subject1Title.setText(org.getSubject1());
        subject2Title.setText(org.getSubject2());
        subject3Title.setText(org.getSubject3());*/
    }
}

/*Label subject1 = new Label("Прикладной мыслитель (210)");
        subject1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(subject1, 0, 1);

                subject1Title = new Text(org.getSubject1());
                subject1Title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(subject1Title, 1, 1, 1, 1);

                Label subject2 = new Label("Фундаментальный лентяй (234)");
                subject2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(subject2, 0, 2);

                subject2Title = new Text(org.getSubject2());
                subject2Title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(subject2Title, 1, 2, 1, 1);

                Label subject3 = new Label("Кабалистика и ворожба (203)");
                subject3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(subject3, 0, 3);

                subject3Title = new Text(org.getSubject3());
                subject3Title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
                grid.add(subject3Title, 1, 3, 1, 1);*/