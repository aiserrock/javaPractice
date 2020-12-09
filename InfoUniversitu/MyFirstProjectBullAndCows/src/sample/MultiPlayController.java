package sample;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sample.Model.BullsAndCows;
import sample.Model.GuessResult;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import sample.SinglePlayController;


public class MultiPlayController implements Initializable {
    public static boolean ID;
    private BullsAndCows player1BC, player2BC;
    private boolean player1Turn, player2Turn;
    private int user1Turns, user2Turns, player, oppozitionPlayer,flag;

    @FXML
    private Label labelGuess1, labelGuess2, labelErrorMessage;
    @FXML
    private TextField textFieldGuess1, textFieldGuess2;
    @FXML
    private Button buttonEnter1, buttonEnter2;
    @FXML
    private TableView<GuessResult> tableView1, tableView2;
    @FXML
    private TableColumn<GuessResult, String> tryColumn1, tryColumn2, bcColumn1, bcColumn2;


    private ObservableList<GuessResult> player1GuessTryTable, player2GuessTryTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            beginTheGame();
    }

    public void beginTheGame() {
        try {
            flag=0;
            numberEnterDialog(1);
            if(flag==1) throw new Exception();
            numberEnterDialog(2);
            if (flag ==1) throw new Exception();
            Controller.isGameStart = true;
            player1Turn = true;
            player2Turn = !player1Turn;
            vizible();
            player1GuessTryTable = FXCollections.observableArrayList();
            player2GuessTryTable = FXCollections.observableArrayList();
            tryColumn1.setCellValueFactory(new PropertyValueFactory<GuessResult, String>("guess_num"));
            bcColumn1.setCellValueFactory(new PropertyValueFactory<GuessResult, String>("guess_result"));
            tryColumn2.setCellValueFactory(new PropertyValueFactory<GuessResult, String>("guess_num"));
            bcColumn2.setCellValueFactory(new PropertyValueFactory<GuessResult, String>("guess_result"));
            tableView1.setItems(player1GuessTryTable);
            tableView2.setItems(player2GuessTryTable);}
        catch(Exception e) {
            exitToMenu();
        }
    }

    public void numberEnterDialog(int n) {
        Dialog<Integer> dialog = new Dialog<>();
        dialog.setTitle("Create number");
        dialog.setHeaderText("Player " + n + " create your number");
        ButtonType loginButtonType = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
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
                switch (n) {
                    case (1):
                        player1BC = new BullsAndCows(str);
                        break;
                    case (2):
                        player2BC = new BullsAndCows(str);
                        break;
                }

            else {
                ErrorMesage(n);
            }
        });
    }
    public void ErrorMesage(int n){
        Alert alert0 = new Alert(Alert.AlertType.ERROR);
        alert0.setTitle("Error");
        alert0.setHeaderText("Incorrect number!");
        alert0.setContentText("Enter \"ОK\", to input number again and for close press \"Close\"");
        Optional<ButtonType> result1 = alert0.showAndWait();
        if (result1.get() == ButtonType.OK)
            numberEnterDialog(n);
        alert0.close();
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

    public void vizible() {
        textFieldGuess1.setVisible(player1Turn);
        labelGuess1.setVisible(player1Turn);
        buttonEnter1.setVisible(player1Turn);
        textFieldGuess2.setVisible(player2Turn);
        labelGuess2.setVisible(player2Turn);
        buttonEnter2.setVisible(player2Turn);

    }

    public static void exitToMenu() {
        Controller.isGameStart = false;
        try {
            Controller.st.setScene(new Scene(new FXMLLoader(Controller.class.getResource("View/MainWindow.fxml")).load()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttonHandleEnter1(ActionEvent actionEvent) {
        player = 1;
        oppozitionPlayer = 2;
        ActionEvent event=actionEvent;
        buttonEnter(event);

    }

    public void buttonHandleEnter2(ActionEvent actionEvent) {
        player = 2;
        oppozitionPlayer = 1;
        ActionEvent event=actionEvent;
        buttonEnter(event);

    }

    public void buttonEnter(ActionEvent actionEvent) {
        labelErrorMessage.setVisible(false);
        if (user1Turns > 14) {
            Alert alertUserOver = new Alert(Alert.AlertType.INFORMATION);
            alertUserOver.setHeaderText("you don't have moves player №" + player + "!");
            alertUserOver.setContentText("Start new game?");
            ButtonType OK = new ButtonType("Start!");
            ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alertUserOver.getButtonTypes().setAll(OK, Cancel);
            Optional<ButtonType> result = alertUserOver.showAndWait();
            if (result.get() == OK)
                beginTheGame();
            else
                exitToMenu();
            return;
        }
        if (user2Turns > 14) {
            Alert alertCompOver = new Alert(Alert.AlertType.INFORMATION);
            alertCompOver.setHeaderText("you don't have moves player №" + oppozitionPlayer + "!");
            alertCompOver.setContentText("Start new game?");
            ButtonType OK = new ButtonType("Start!");
            ButtonType Cancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alertCompOver.getButtonTypes().setAll(OK, Cancel);
            Optional<ButtonType> result = alertCompOver.showAndWait();
            if (result.get() == OK)
                beginTheGame();
            else
                exitToMenu();
            return;
        }
        if (player == 1) {
            Platform.runLater(() -> textFieldGuess1.requestFocus());
            String str = textFieldGuess1.getText();
            if (isNumberCorrect(str)) {
                player1GuessTryTable.add(new GuessResult(str, player2BC.toString(new BullsAndCows(str))));
                BullsAndCows bc_temp = new BullsAndCows(str);
                if (player2BC.hmB(bc_temp) == 4) {
                    Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
                    alertUserWon.setHeaderText("Win player № "+oppozitionPlayer+"!");
                    alertUserWon.setContentText("You guess computer's number!\nYou want start new game or exit?");
                    ButtonType OK = new ButtonType("Start!");
                    ButtonType Cancel = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alertUserWon.getButtonTypes().setAll(OK, Cancel);
                    Optional<ButtonType> result = alertUserWon.showAndWait();
                    if (result.get() == OK)
                        beginTheGame();
                    else
                        exitToMenu();
                    return;
                } else {
                    user1Turns++;
                    player1Turn = false;
                    player2Turn = !player1Turn;
                    vizible();
                    return;
                }
            } else {
                labelErrorMessage.setVisible(true);
                labelErrorMessage.setText("Error input!");
                labelErrorMessage.setTextFill(Color.RED);
            }
        } else {
            Platform.runLater(() -> textFieldGuess2.requestFocus());
            String str = textFieldGuess2.getText();
            if (isNumberCorrect(str)) {
                player2GuessTryTable.add(new GuessResult(str, player1BC.toString(new BullsAndCows(str))));
                BullsAndCows bc_temp = new BullsAndCows(str);
                if (player1BC.hmB(bc_temp) == 4) {
                    Alert alertUserWon = new Alert(Alert.AlertType.INFORMATION);
                    alertUserWon.setHeaderText("Win player "+player+"!");
                    alertUserWon.setContentText("You guess computer's number!\nYou want start new game or exit?");
                    ButtonType OK = new ButtonType("Start!");
                    ButtonType Cancel = new ButtonType("Exit", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alertUserWon.getButtonTypes().setAll(OK, Cancel);
                    Optional<ButtonType> result = alertUserWon.showAndWait();
                    if (result.get() == OK)
                        beginTheGame();
                    else
                        exitToMenu();
                    return;
                } else {
                    user2Turns++;
                    player2Turn = false;
                    player1Turn = !player2Turn;
                    vizible();
                    return;
                }
            } else {
                labelErrorMessage.setVisible(true);
                labelErrorMessage.setText("Error input!");
                labelErrorMessage.setTextFill(Color.RED);
            }
            return;
        }


    }
}
