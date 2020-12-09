package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    /* Main Window */
    public Stage mainWindow;
    /*Main scene*/
    public static Scene mainScene;
    /*First scene for 1-player game */
    public static Scene SinglePlayScene;
    /*Second scene for 2-player game */
    public static Scene MultiPlayScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        mainWindow.setTitle("Bulls and Cows");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View/MainWindow.fxml"));
        primaryStage.getIcons().add(new Image("file:resources/icon.png"));

        try {
            Controller mainStageController = loader.getController();
            mainStageController.setStage(primaryStage);
            mainScene = new Scene(loader.load());
            mainWindow.setScene(mainScene);
            mainWindow.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
