package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import sample.SinglePlayController;
import sample.MultiPlayController;

public class Controller implements Initializable {
    public static boolean isGameStart;
    public static Stage st;
    @FXML
    AnchorPane root;
    @FXML
    private HBox hmenu;
    public MenuBar menuBar;
    @FXML
    private VBox vBox;
    @FXML
    AnchorPane rootSinglePlay;
    @FXML
    AnchorPane rootMultiPlay;

    public static void setStage(Stage getStage) {
        st = getStage;
    }
    /*Changing the scene on the main stage*/
    public void changeScene(int num){
        root.getChildren().remove(vBox);
        switch (num) {
            case (1):
                try {
                    root.getChildren().addAll((Node) FXMLLoader.load(Controller.class.getResource("View/SinglePlay.fxml")));
                    root.getChildren().remove(rootMultiPlay);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case (2):
                try {
                    root.getChildren().addAll((Node) FXMLLoader.load(Controller.class.getResource("View/MultiPlay.fxml")));
                    root.getChildren().remove(rootSinglePlay);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    /*Overriding method initialize because of implementing "Initializable" interface*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //menuBar.prefWidthProperty().bind(st.widthProperty());
    }

    public void handleFilePlay() {
        if (!isGameStart) {
            chooseNumPlayers();
        } else {
            Alert alert0 = new Alert(Alert.AlertType.CONFIRMATION);
            alert0.setTitle("Warning!");
            alert0.setContentText("Are you sure???");
            alert0.setHeaderText(null);
            Optional<ButtonType> resultChoose1 = alert0.showAndWait();
            if (resultChoose1.get() == ButtonType.OK) {
                isGameStart = false;
                handleFilePlay();
            } else {
                alert0.close();
            }
        }
    }
    public void chooseNumPlayers() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Let's start!");
        alert.setHeaderText("You can choose partner:");
        alert.setContentText(null);

        ButtonType buttonTypeSingle = new ButtonType("SinglePlay");
        ButtonType buttonTypeMulti = new ButtonType("MultiPlay");
        ButtonType buttonTypeQuit = new ButtonType("Quit", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeSingle, buttonTypeMulti, buttonTypeQuit);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeSingle) {
            changeScene(1);
        } else if (result.get() == buttonTypeMulti) {
            changeScene(2);
        } else {
            alert.close();
        }
    }

    public void handleAboutProgram() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Program");
        alert.setHeaderText(null);
        alert.setContentText("Bulls and Cows " +
                             "\nVersion --: 1  " +
                             "\nMade by Vladislav it-22bo");
        alert.showAndWait();

    }
    public void handleAboutGame() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Game");
        alert.setHeaderText(null);
        alert.setContentText("Each of the opponents conceives a four-digit number, all the digits of which are different\n" +
                             "(the first digit of the number is different from zero). Need to unravel the intended number.\n" +
                             " The one who guesses the first wins. Opponents in turn call each other a number and report\n" +
                             "the number of \"bulls\" and \"cows\" in the named number (\"bull\" - the figure is in the record\n" +
                             "of the planned number and is in the same position as in the intended number; \"ko-rova\" - the figure\n" +
                             "is in the record of the intended number, but not in the same position as in the intended number).\n" +
                             "For example, if the number 3275 is conceived and the number is 1234, we get one “bull” and one “cow”\n" +
                             "in the named number. The number is guessed in that case if it turned out 4 \"bull\". ");
        alert.showAndWait();

    }

    public void handleFileExit() {
        st.close();
    }

    public void handleFileGoToHome(ActionEvent actionEvent) {
        if(isGameStart)
            SinglePlayController.exitToMenu();
    }
}
