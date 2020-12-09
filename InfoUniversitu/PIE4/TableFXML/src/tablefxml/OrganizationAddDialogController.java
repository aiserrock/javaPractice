/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablefxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nadezhda
 */
public class OrganizationAddDialogController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField addName;
    @FXML
    private TextField addBossName;
    @FXML
    private TextField addPersonnel;

    private Stage dialogStage;
    private Organization org;
    private boolean okClicked = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setOrganization(Organization org) {
        this.org = org;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (addName.getText() == null || addName.getText().length() == 0) {
            errorMessage += "No valid organization name!\n";
        }
        if (addBossName.getText() == null || addBossName.getText().length() == 0) {
            errorMessage += "No valid boss name!\n";
        }
        if (addPersonnel.getText() == null || addPersonnel.getText().length() == 0) {
            errorMessage += "No valid personnel!\n";
        } else {
            try {
                Integer.parseInt(addPersonnel.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid personnel (must be an integer)!\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            //org = new Organization(addName.getText(), addBossName.getText(), Integer.parseInt(addPersonnel.getText()));
            org.setName(addName.getText());
            org.setBossName(addBossName.getText());
            org.setPersonnel(Integer.parseInt(addPersonnel.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() {
        okClicked = false;
        dialogStage.close();
    }

}
