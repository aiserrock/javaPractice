package exampledrawing;


import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ExampleDrawing extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * 
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing");
        VBox root = new VBox();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        ToggleButton btn = new ToggleButton();
//        btn.setLayoutX(200);
//        btn.setLayoutY(200);
        btn.setText("show");
        root.getChildren().add(btn);
        btn.setOnAction((ActionEvent event) -> {
            if (btn.isSelected()) {
                drawShapes(gc);
                gc.clearRect(0, 100, 300, 250);
            } else {
                drawShapes(gc);
                gc.clearRect(0, 0, 300, 100);
                
            }
        });
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GOLD);
        gc.setStroke(Color.GOLD);
        gc.setLineWidth(1);
        gc.fillOval(30, 30, 40, 40);
        gc.strokeLine(50, 50, 50, 80);
        gc.strokeLine(50, 50, 50, 20);
        gc.strokeLine(50, 50, 20, 50);
        gc.strokeLine(50, 50, 80, 50);
        gc.strokeLine(50, 50, 70, 80);
        gc.strokeLine(50, 50, 30, 20);
        gc.strokeLine(50, 50, 20, 80);
        gc.strokeLine(50, 50, 80, 20);
        gc.strokeText("SUN", 150, 50);
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
        gc.fillRoundRect(40,100 , 60, 30, 25, 25);
        gc.strokeLine(50, 100, 40, 150);
        gc.strokeLine(55, 100, 45, 150);
        gc.strokeLine(60, 100, 50, 150);
        gc.strokeLine(65, 100, 55, 150);
        gc.strokeText("CLOUD", 150, 120);
       
        }

} 