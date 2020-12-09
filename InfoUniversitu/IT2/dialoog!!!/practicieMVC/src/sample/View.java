package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class View extends Group {
        private Model model;
        private GridPane grid;

        private void createPane(){
            grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(34);
            grid.setVgap(14);
            grid.setPadding(new Insets(25, 25, 25, 25));

            Text personNameTitle = new Text("Name");
            personNameTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid.add(personNameTitle, 0, 0);

            Text namePerson = new Text(model.getNamePerson());
            namePerson.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            namePerson.textProperty().bind(model.namePersonStringProperty());
            GridPane.setHalignment(namePerson, HPos.CENTER);
            grid.add(namePerson, 1, 0, 1, 1);


            Text personAgeTitle = new Text("Age");
            personAgeTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid.add(personAgeTitle, 0, 2);


            Text personAge = new Text();
            personAge.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            personAge.textProperty().bind(model.personAgeIntegerProperty().asString());
            grid.add(personAge, 1, 2);

            Text personStatusTitle = new Text("Status");
            personStatusTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid.add(personStatusTitle, 0, 3);


            Text personStatus = new Text(model.getStatus());
            personStatus.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            personStatus.textProperty().bind(model.WhatStatus());
            grid.add(personStatus, 1, 3);
        }
        public void setModel (Model model) {
            this.model = model;
        }
        public View(Model model) {
            setModel (model);
            createPane();
            this.getChildren().add(grid);
        }
    }
