/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteragefxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author nadezhda
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Text actiontarget;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField valueYear;
    
    private Person person;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            if (person == null) {
                person = new Person(nameTextField.getText(), valueYear.getText());
            } else {
                person.setName(nameTextField.getText());
                person.setAge(valueYear.getText());
            }
            actiontarget.setText(person.getStatus());
        } catch (Exception er) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Ошибка ввода данных");
            alert.setHeaderText(er.getMessage());
            alert.setContentText("Имя начинается с большой буквы, \nа год рождения больше нуля");
            alert.showAndWait();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
