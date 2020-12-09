/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labclassevent;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author zaikin
 */
public class MeLabel extends Label{
    private Font tmp = getFont();
    private String str;
     public MeLabel(String text) {
        super(text);
        setPrefWidth(50);
        setPrefHeight(50);
        setAlignment(Pos.CENTER);
        
        setFocusTraversable(true);
        
        
         addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            System.out.println("Mouse entered");
            setFont(Font.font(50));
            requestFocus();
            
        });
         addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            System.out.println("Mouse exited");
            setFont(tmp);
            //((HBox)MeLabel.this.getParent()).setRequest();
       
            //requestFocus();
            
                     });
            
           addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            if (e.isPrimaryButtonDown()) {
                System.out.println("Mouse pressed PRIMARY");
            setTextFill(Color.RED);
            requestFocus();
            }
                      
                });
           
          addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            if (e.isSecondaryButtonDown()) {
                System.out.println("Mouse pressed SECONDARY");
            setTextFill(Color.BLACK);
            requestFocus();
            }
    
    });
          addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) -> {
            if (e.getClickCount()==2) {
                System.out.println("Mouse pressed twice");
               str=getText();
               setText("$");
           // requestFocus();
            }
          });
//          
        addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent ke) -> {
             System.out.println("Key Pressed: " + ke.getText());
             
           if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                setTextFill(Color.GREENYELLOW);
           }
            if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                       setTextFill(Color.GREENYELLOW);
            }
            if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                setTextFill(Color.GREENYELLOW);
            }
            if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                setTextFill(Color.GREENYELLOW);
                
            }
            if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                setTextFill(Color.GREENYELLOW);
                
            }
            if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                setTextFill(Color.GREENYELLOW);
                
            }
            if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                setTextFill(Color.GREENYELLOW);
                
            }
            if (ke.getText().equalsIgnoreCase(MeLabel.this.getText())) {
                setTextFill(Color.GREENYELLOW);
            }
            //requestFocus();
          });
}
}
