package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class Main extends Application {


        private ObservableList<Model> modelsList;
        private TableView<Model> dataTableView;
        private MenuBar mb;
        private int col;

        private void createTableView() {
            TableColumn<Model, String> kindCol = new TableColumn<>("Kind");
            kindCol.setCellValueFactory(new PropertyValueFactory("kind"));

            TableColumn<Model, String> ageCol = new TableColumn<>("Age");
            ageCol.setCellValueFactory(new PropertyValueFactory("age"));

            TableColumn<Model, String> nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory("name"));

            dataTableView.getColumns().setAll(kindCol,nameCol,ageCol);

        }

        private void showMessage(String message) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }


        private void handleButtonAdd() {
            Model model = new Model("Kind", 0, "Name");
            ModelDialog modDialog = new ModelDialog(model, "Add model");
            Optional<Model> result = modDialog.getDialog().showAndWait();
            if (result.isPresent()) {
                modelsList.add(result.get());
            }
        }

        private void handleButtonDelete() {
            int selectedIndex = dataTableView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                dataTableView.getItems().remove(selectedIndex);
            } else {
                showMessage("No deleted item!");
            }
        }





    private void handleFileOpen() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Data File");
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            return;
        }
        String str, data[];
        Scanner in = new Scanner(file);
        while(in.hasNextLine()) {
            if (in.hasNextLine()) {
                str = in.nextLine();
            } else {
                throw new IOException();
            }
            //System.out.println(str);
            data = str.split(",");
            Model model =new Model(data[0],Integer.parseInt(data[2]),data[1]);
            modelsList.add(model);
            col++;

        }
        in.close();
    }

    private void handleFileSave() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Data File");
        File file = fileChooser.showSaveDialog(null);
        if (file == null) {
            return;
        }
        FileWriter out = new FileWriter(file);
        for(int i=0;i<col;i++) {
            out.write(modelsList.get(i).getKind() + "," + modelsList.get(i).getName() + "," + modelsList.get(i).getAge()+"\n");
        }
        out.close();
    }


    private void createFileMenu() {
        Menu fileMenu = new Menu("_File");
        MenuItem open = new MenuItem("Open");
        open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
        MenuItem save = new MenuItem("Save");
        save.setAccelerator(KeyCombination.keyCombination("shortcut+s"));
        MenuItem exit = new MenuItem("Exit");
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+esc"));
        fileMenu.getItems().addAll(open, save, new SeparatorMenuItem(), exit);
        open.setOnAction((ActionEvent event) -> {
            try {
                handleFileOpen();
            } catch (IOException e) {
                showMessage("Input file error");
                System.out.println("Input file error");
            }
        });
        save.setOnAction((ActionEvent event) -> {
            try {
                handleFileSave();
            } catch (IOException e) {
                showMessage("Output file error");
                System.out.println("Output file error");
            }
        });
        exit.setOnAction((ActionEvent event) -> {
            Platform.exit();
        });
        mb.getMenus().add(fileMenu);
    }

    private void createAddMenu() {
        Menu addMenu = new Menu("Add");
        MenuItem add = new MenuItem("Add pet");
        add.setAccelerator(KeyCombination.keyCombination("shortcut+1"));
        addMenu.getItems().add(add);
            add.setOnAction((ActionEvent e) ->handleButtonAdd());
        mb.getMenus().add(addMenu);
        col++;
    }

    private void createDeleteMenu() {
        Menu dellMenu = new Menu("Delete");
        MenuItem dell = new MenuItem("Delete pet");
        dell.setAccelerator(KeyCombination.keyCombination("shortcut+2"));
        dellMenu.getItems().add(dell);
        dell.setOnAction((ActionEvent e) ->handleButtonDelete());
        mb.getMenus().add(dellMenu);
        col--;
    }


    private void createAboutMenu() {
        Menu aboutMenu = new Menu("About");
        MenuItem about = new MenuItem("About");
        aboutMenu.getItems().add(about);
        about.setOnAction((ActionEvent event) -> {
            Alert msg = new Alert(Alert.AlertType.INFORMATION);
            msg.setTitle("About");
            msg.setHeaderText(null);
            msg.setContentText("This project make Zaikin Vladislav IT-22");
            msg.show();
        });
        mb.getMenus().add(aboutMenu);
    }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("List of pets");

            BorderPane root = new BorderPane();
            root.setPadding(new Insets(5));

            modelsList = FXCollections.<Model>observableArrayList();
            dataTableView = new TableView<>();

            createTableView();
            dataTableView.setItems(modelsList);
            root.setCenter(dataTableView);


            mb = new MenuBar();
            createFileMenu();
            createAddMenu();
            createDeleteMenu();
            createAboutMenu();
            root.setTop(mb);

            Scene scene = new Scene(root, 800, 500, Color.WHITE);
            primaryStage.setScene(scene);
            primaryStage.show();
        }



    public static void main(String[] args) {
        launch(args);
    }
}
