package labclassevent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LabClassEvent extends Application {
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        //hbox.setStyle("-fx-background-color: #336699;");


        MeLabel labe1 = new MeLabel("C");
        MeLabel labe2 = new MeLabel("O");
        MeLabel labe3 = new MeLabel("M");
        MeLabel labe4 = new MeLabel("P");
        MeLabel labe5 = new MeLabel("U");
        MeLabel labe6 = new MeLabel("T");
        MeLabel labe7 = new MeLabel("E");
        MeLabel labe8 = new MeLabel("R");
     
        hbox.getChildren().addAll(labe1,labe2,labe3,labe4,labe5,labe6,labe7,labe8);

        return hbox;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox hbox = addHBox();
        Scene scene = new Scene(hbox,300,200);
        //scene.getStylesheets().add("style.css");
        primaryStage.setTitle("emitation keyboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
