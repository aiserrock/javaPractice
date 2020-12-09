/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampledrawing;

/**import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;


 *
 * @author nadezhda
 */

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ExampleDrawing extends Application {
   /* @Override
    public void start(Stage primaryStage) {
 
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        initDraw(graphicsContext);
         
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent event) -> {
            graphicsContext.beginPath();
            graphicsContext.moveTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });
         
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent event) -> {
            graphicsContext.lineTo(event.getX(), event.getY());
            graphicsContext.stroke();
        });
 
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent event) -> {
        });
 
        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
     
    private void initDraw(GraphicsContext gc){
        double canvasWidth = gc.getCanvas().getWidth();
        double canvasHeight = gc.getCanvas().getHeight();
         
        gc.setFill(Color.LIGHTGRAY);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
 
        gc.fill();
        gc.strokeRect(
                0,              //x of the upper left corner
                0,              //y of the upper left corner
                canvasWidth,    //width of the rectangle
                canvasHeight);  //height of the rectangle
         
        gc.setFill(Color.RED);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1);
    }*/
 

    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        ToggleButton btn = new ToggleButton();
        root.getChildren().add(btn);
        btn.setOnAction((ActionEvent e) -> {
            drawShapes(gc);
        });
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
//        VBox root = new VBox();
//        Canvas canvas = new Canvas(300, 250);
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        //drawShapes(gc);
        
//        root.getChildren().add(canvas);
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
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