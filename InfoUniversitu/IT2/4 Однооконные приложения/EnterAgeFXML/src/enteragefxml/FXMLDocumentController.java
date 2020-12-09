/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enteragefxml;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
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
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String year = valueYear.getText();
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
        calendar.setTime(new Date());
        if (year.matches("[0-9]+")) {
            int age = calendar.get(Calendar.YEAR) - Integer.parseInt(year);
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText(nameTextField.getText() + " was " + Integer.toString(age) + " years old");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
