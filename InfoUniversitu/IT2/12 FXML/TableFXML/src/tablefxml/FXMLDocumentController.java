/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablefxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author nadezhda
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Organization> table;
    @FXML
    private TableColumn<Organization, String> nameCol;
    @FXML
    private TableColumn<Organization, String> bossNameCol;
    @FXML
    private TableColumn<Organization, String> personnelCol;

    private TableFXML mainApp;

    @FXML
    private void addButtonAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(TableFXML.class.getResource("OrganizationAddDialog.fxml"));
            Parent root = loader.load();
            OrganizationAddDialogController controller = loader.getController();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Organization");
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            controller.setDialogStage(dialogStage);
            Organization org = new Organization("", "", 0);
            controller.setOrganization(org);
            dialogStage.showAndWait();
            if (controller.isOkClicked()) {
                mainApp.getData().add(org);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    private void deleteButtonAction(ActionEvent event) {
        int selectedIndex = table.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                table.getItems().remove(selectedIndex);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No deleted item!");
            alert.setHeaderText("Please select item!");
            alert.setContentText("No deleted item!");
            alert.showAndWait();
            }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        bossNameCol.setCellValueFactory(new PropertyValueFactory<>("bossName"));
        personnelCol.setCellValueFactory(new PropertyValueFactory<>("personnel"));
    }
    
    public void setMainApp(TableFXML mainApp) {
        this.mainApp = mainApp;
        table.setItems(mainApp.getData());
    }

}
