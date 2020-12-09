/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouseeventexample;

import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class MouseEventExample extends Application {

    private int windowWidth = 600;
    private int windowHeight = 600;
    private Random random = new Random();
    private Point2D delta;
    private boolean isRotate;

    private Scene createScene() {
        Group root = new Group();
        for (int i = 0; i < 5; i++) {
            root.getChildren().add(createLabel());
        }
        Scene scene = new Scene(root, windowWidth, windowHeight);
        return scene;

    }

    private Label createLabel() {
        Label label = new Label("SomeText");
        label.setPrefWidth(100);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
        label.setBackground(new Background(new BackgroundFill(Color.AQUA, null, null)));
        label.setLayoutY(random.nextDouble() * 500);
        label.setLayoutX(random.nextDouble() * 500);
        label.setRotate(random.nextDouble() * 180);
        addTranslateListener(label);
        return label;
    }

    private void addTranslateListener(final Node node) {
        node.setOnMousePressed((MouseEvent mouseEvent) -> {
            delta = new Point2D((mouseEvent.getSceneX() - node.getLayoutX()),
                    (mouseEvent.getSceneY() - node.getLayoutY()));
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                isRotate = true;
            }
        });

        node.setOnMouseReleased((MouseEvent mouseEvent) -> {
            isRotate = false;
        });

        node.setOnMouseDragged((MouseEvent mouseEvent) -> {
            if (isRotate) {
                // подсчет нового угла основывается на подсчете угла между двумя векторами 

                double dx1 = mouseEvent.getSceneX() - node.getLayoutX();
                double dy1 = mouseEvent.getSceneY() - node.getLayoutY();
                double l = Math.sqrt(dx1 * dx1 + dy1 * dy1);
                dx1 /= l; // нормализация 
                dy1 /= l; // вектора 

                double angle = Math.PI / 2; //  второй вектор
                double dx2 = Math.sin(angle);      // единичный вектор,                           
                double dy2 = Math.cos(angle);      // который повернутый на 90 градусов 

                double cosA = dx1 * dx2 + dy1 * dy2;
                angle = Math.acos(cosA);

                if (dy1 < 0) {
                    angle = Math.PI - angle;
                }
                node.setRotate(angle / Math.PI * 180); // из радиан в градусы 
            } else {
                node.setLayoutX(mouseEvent.getSceneX() - delta.getX());
                node.setLayoutY(mouseEvent.getSceneY() - delta.getY());
            }
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Simple Application");
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
