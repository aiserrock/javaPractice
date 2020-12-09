/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampletaskandprogressbar;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class ExampleTaskAndProgressBar extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        final Label statusLabel = new Label("Status");
        final Button runButton = new Button("Run");
        final ListView<String> peopleView = new ListView<String>();
        peopleView.setPrefSize(220, 160);
        final ProgressBar progressBar = new ProgressBar();
        progressBar.prefWidthProperty().bind(peopleView.prefWidthProperty());

        runButton.setOnAction((ActionEvent actionEvent) -> {
            Task task = new Task<ObservableList<String>>() {
                @Override
                protected ObservableList<String> call() throws InterruptedException {
                    updateMessage("Finding friends . . .");
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(200);
                        updateProgress(i + 1, 10);
                    }
                    updateMessage("Finished.");
                    return FXCollections.observableArrayList("John", "Jim", "Geoff", "Jill", "Ann");
                }
            };
            
            statusLabel.textProperty().bind(task.messageProperty());
            runButton.disableProperty().bind(task.runningProperty());
            peopleView.itemsProperty().bind(task.valueProperty());
            progressBar.progressProperty().bind(task.progressProperty());
            
            task.stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State newState) {
                    if (newState == Worker.State.SUCCEEDED) {
                        //System.out.println("This is ok, this thread " + Thread.currentThread() + " is the JavaFX Application thread.");
                        runButton.setText("Voila!");
                    }
                }
            });
            
            new Thread(task).start();
        });

        final VBox root = new VBox();
        root.setSpacing(10);
        root.getChildren().addAll(runButton, statusLabel, progressBar, peopleView);
        root.setStyle("-fx-background-color: cornsilk; -fx-padding:10; -fx-font-size: 16;");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
