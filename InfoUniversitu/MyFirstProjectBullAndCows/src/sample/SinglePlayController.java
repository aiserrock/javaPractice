package sample;

import javafx.scene.layout.AnchorPane;
import sample.Model.BullsAndCows;
import sample.Model.GuessResult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import sample.Controller;

import static sample.Controller.isGameStart;

public class SinglePlayController implements Initializable {
    private BullsAndCows playersBC;
    private BullsAndCows compBC;
    int userTurns = 0, compTurns = 0,flag;
    public static boolean ID;
    @FXML
    AnchorPane rootSinglePlay;
    @FXML
    private TextField textFieldGuess;
    @FXML
    private Button buttonEnter;
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<GuessResult> tableView;
    @FXML
    private TableColumn<GuessResult, String> tryColumn;
    @FXML
    private TableColumn<GuessResult, String> bcColumn;
    @FXML
    private Label labelErrorMessage;

    private ObservableList<GuessResult> userGuessTryTable;

    public void beginTheGame() {
        try {
            flag =0;
            numberEnterDialog();
            if(flag ==1) throw new Exception();
            compBC = new BullsAndCows();
            isGameStart = true;
            userGuessTryTable = FXCollections.observableArrayList();
            tryColumn.setCellValueFactory(new PropertyValueFactory<GuessResult, String>("guess_num"));
            bcColumn.setCellValueFactory(new PropertyValueFactory<GuessResult, String>("guess_result"));
            tableView.setItems(userGuessTryTable);
        }
        catch (Exception e){
            exitToMenu();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        beginTheGame();
    }

    public void numberEnterDialog(){

        Dialog<Integer> dialog = new Dialog<>();
        dialog.setTitle("Guess number");
       /* dialog.getDialogPane().getStylesheets().add(
                getClass().getResource("styleSinglePlay.css").toExternalForm());*/

        dialog.setHeaderText(null);
        ButtonType loginButtonType = new ButtonType("Accept", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        TextField userNumberField = new TextField();
        userNumberField.setPrefWidth(300);
        userNumberField.setPromptText("1234 (number without repeating numbers)");
        grid.add(userNumberField, 1, 0);
        dialog.getDialogPane().setContent(grid);
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Integer(userNumberField.getText());
            }
            flag =1;
            return null;
        });
        Optional<Integer> result = dialog.showAndWait();
        result.ifPresent(str -> {
            if (isNumberCorrect(str.toString()))
                playersBC = new BullsAndCows(str);
            else {
                try {
                    ErrorMesage();
                }
               catch (Exception e){
                    exitToMenu();
               }
            }
        });
    }

    public void ErrorMesage(){
        Alert alert0 = new Alert(Alert.AlertType.ERROR);
        alert0.setTitle("Error");
        alert0.setHeaderText("Incorrect number");
        alert0.setContentText("Press \"OK\", that input number again, for exit press \"Close\" ");
        Optional<ButtonType> result1 = alert0.showAndWait();
        if (result1.get() == ButtonType.OK)
            beginTheGame();
        alert0.close();

    }
    public void buttonEnter() {
        labelErrorMessage.setVisible(false);
        System.out.println(compBC.getBullsAndCows());
        String str = textFieldGuess.getText();
        if (userTurns > 14){
            Alert alertGameOver = new Alert(Alert.AlertType.INFORMATION);
            alertGameOver.setHeaderText("you don't have moves!");
            alertGameOver.setContentText("Start new game?");
            ButtonType OK = new ButtonType("OK!");
            ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alertGameOver.getButtonTypes().setAll(OK,Cancel);
            Optional<ButtonType> result = alertGameOver.showAndWait();
            if(result.get() == OK)
                beginTheGame();
            else
                exitToMenu();
            return;
        }
        if (compTurns > 14) {
            Alert alertCompOver = new Alert(Alert.AlertType.INFORMATION);
            alertCompOver.setHeaderText("Computer don't have moves!");
            alertCompOver.setContentText("Start new game?");
            ButtonType OK = new ButtonType("OK!");
            ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alertCompOver.getButtonTypes().setAll(OK,Cancel);
            Optional<ButtonType> result = alertCompOver.showAndWait();
            if(result.get() == OK)
                beginTheGame();
            else
                exitToMenu();
            return;
        }
        if (isNumberCorrect(str)) {
            userGuessTryTable.add(new GuessResult(str, compBC.toString(new BullsAndCows(str))));
            BullsAndCows temp = new BullsAndCows(str);
            if (compBC.hmB(temp) == 4){
                Alert alertGameWin = new Alert(Alert.AlertType.INFORMATION);
                alertGameWin.setHeaderText("Win!");
                alertGameWin.setContentText("You guess computer's number!\nYou want start new game or exit?");
                ButtonType OK = new ButtonType("Start!");
                ButtonType Cancel = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);
                alertGameWin.getButtonTypes().setAll(OK,Cancel);
                Optional<ButtonType> result = alertGameWin.showAndWait();
                if(result.get() == OK){
                    beginTheGame();
                }
                else{
                    exitToMenu();
                }
                return;
            }
            else {
                userTurns++;
                compTurns++;//move computer
                /*
                *
                *
                *
                */
                return;
            }
        } else {
            labelErrorMessage.setVisible(true);
            labelErrorMessage.setText("Error input!");
            labelErrorMessage.setTextFill(Color.RED);
        }
        return;
    }
    public boolean isNumberCorrect(String a) {
        if (a.length() != 4)
            return false;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (a.charAt(i) == a.charAt(j))
                    return false;
            }
        }
        return true;
    }

    public static void exitToMenu(){
        isGameStart = false;
        try {
            Controller.st.setScene(new Scene(new FXMLLoader(Controller.class.getResource("View/MainWindow.fxml")).load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

