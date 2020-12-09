/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author nadezhda
 */
public class TABLE extends Application {

    private TableView<Organization> table = new TableView<Organization>();
    private TableColumn nameCol = new TableColumn("Name");
    private TableColumn bossNameCol = new TableColumn("Boss Name");
    private TableColumn personnelCol = new TableColumn("Personnel");

    private ObservableList<Organization> data
            = FXCollections.observableArrayList(
                    new Organization("Kalipso", "Smith", 1200),
                    new Organization("DoggyStyle", "Johnson", 150),
                    new Organization("Galaxy", "Williams", 25),
                    new Organization("Bubble", "Jones", 0),
                    new Organization("Kangaroo", "Brown", 560));
    HBox hb = new HBox();

    private void createTable() {

        table.setEditable(true);
        
        TableColumn<Organization, Number> indexColumn = new TableColumn<Organization, Number>("#");
        indexColumn.setMinWidth(50);
        indexColumn.setSortable(false);
        indexColumn.setCellValueFactory(column -> new ReadOnlyObjectWrapper<Number>(table.getItems().indexOf(column.getValue())));

        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Organization, String>("name"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Organization, String>>() {
                    @Override
                    public void handle(CellEditEvent<Organization, String> t) {
                        ((Organization) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setName(t.getNewValue());
                    }
                }
        );

        bossNameCol.setMinWidth(100);
        bossNameCol.setCellValueFactory(
                new PropertyValueFactory<Organization, String>("bossName"));
        bossNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        bossNameCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Organization, String>>() {
                    @Override
                    public void handle(CellEditEvent<Organization, String> t) {
                        ((Organization) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setBossName(t.getNewValue());
                    }
                }
        );

        personnelCol.setMinWidth(100);
        personnelCol.setCellValueFactory(
                new PropertyValueFactory<Organization, Integer>("personnel"));
        personnelCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        personnelCol.setOnEditCommit(
                new EventHandler<CellEditEvent<Organization, Integer>>() {
                    @Override
                    public void handle(CellEditEvent<Organization, Integer> t) {
                        ((Organization) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())).setPersonnel(t.getNewValue());
                    }
                }
        );

        TableColumn dataCol = new TableColumn("Data");
        dataCol.setMinWidth(300);
        dataCol.getColumns().addAll(personnelCol, bossNameCol);

        table.setItems(data);
        table.getColumns().addAll(indexColumn, nameCol, dataCol);
    }

    private void dataEditGroup() {
        TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setMaxWidth(nameCol.getPrefWidth());
        TextField addBossName = new TextField();
        addBossName.setMaxWidth(bossNameCol.getPrefWidth());
        addBossName.setPromptText("Boss Name");
        TextField addPersonnel = new TextField();
        addPersonnel.setMaxWidth(personnelCol.getPrefWidth());
        addPersonnel.setPromptText("Personnel");

        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new Organization(
                    addName.getText(),
                    addBossName.getText(),
                    Integer.parseInt(addPersonnel.getText())));
            addName.clear();
            addBossName.clear();
            addPersonnel.clear();
        });
        hb.getChildren().addAll(addName, addBossName, addPersonnel, addButton);
        hb.setSpacing(3);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(450);
        stage.setHeight(550);
        
        createTable();
        
        Label label = new Label("Organizations List");
        label.setFont(new Font("Arial", 20));
        
        dataEditGroup();
        
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}
