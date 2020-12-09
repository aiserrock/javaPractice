package events;

import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nadezhda
 */
public class MyLabel extends Label {

    private Random random = new Random();
    private Point2D delta;
    private boolean isRotate;
    private boolean isSelected = false;

    public MyLabel(String text) {
        super(text);
        setPrefWidth(100);
        setPrefHeight(50);
        setAlignment(Pos.CENTER);
        setLayoutY(random.nextDouble() * 500);
        setLayoutX(random.nextDouble() * 500);
        setRotate(random.nextDouble() * 180);
        setFocusTraversable(true);
        addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            requestFocus();
            mousePressed(e);
        });
        addEventHandler(MouseEvent.MOUSE_RELEASED, (MouseEvent e) -> {
            mouseReleased(e);
        });
        addEventHandler(MouseEvent.MOUSE_DRAGGED, (MouseEvent e) -> {
            mouseDragged(e);
        });
        addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent e) -> {
            keyPressed(e);
        });
    }

    public void mousePressed(MouseEvent mouseEvent) {
        delta = new Point2D((mouseEvent.getSceneX() - getLayoutX()),
                (mouseEvent.getSceneY() - getLayoutY()));
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            isRotate = true;
        }
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        isRotate = false;
    }

    public void mouseDragged(MouseEvent mouseEvent) {
        if (isRotate) {
            // подсчет нового угла основывается на подсчете угла между двумя векторами 

            double dx1 = mouseEvent.getSceneX() - getLayoutX();
            double dy1 = mouseEvent.getSceneY() - getLayoutY();
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
            setRotate(angle / Math.PI * 180); // из радиан в градусы 
        } else {
            setLayoutX(mouseEvent.getSceneX() - delta.getX());
            setLayoutY(mouseEvent.getSceneY() - delta.getY());
        }
    }

    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.A) {
            setText("aaaaaaaaaa");
        }
        if (keyEvent.getCode() == KeyCode.A && keyEvent.isShiftDown()) {
            setText("AAAAAAA");
        }
    }
}
