package sample;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Simple Model-View Data Binding PracticieMVC5");
        final Model model = new Model("--Enter name--",40,"");
        HBox root = new HBox(30);

        View viewOrg = new View(model);
        root.getChildren().add(viewOrg);

        root.getChildren().add(new Separator(Orientation.VERTICAL));

        root.getChildren().add(editBlock(model));

        Scene scene = new Scene(root, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox editBlock(Model model){
        VBox editPane = new VBox(10);
        editPane.setPadding(new Insets(20));

        Label labelTitle = new Label("Enter name person\n and age person");
        labelTitle.setFont(Font.font(20));

        final TextField editName = new TextField();
        editName.setFont(Font.font(20));
        editName.setPrefSize(150, 40);

        final TextField editAge = new TextField();
        editAge.setFont(Font.font(20));
        editAge.setPrefSize(150, 40);

        Button btn = new Button("Edit");
        btn.setFont(Font.font(20));
        btn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                model.setNamePerson(editName.getText());
                model.setPersonAge(Integer.parseInt(editAge.getText()));
            }
        });

        editPane.getChildren().addAll(labelTitle, editName, editAge, btn);
        return editPane;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
