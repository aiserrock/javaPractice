/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablefxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.stage.FileChooser;
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
    private void saveAction(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Data File");
            File file = fileChooser.showSaveDialog(null);
            if (file == null) {
                return;
            }
            FileWriter out = new FileWriter(file);
            for (Organization org : table.getItems()) {
                out.write(org.getName() + " " + org.getPersonnel() + " " 
                        + org.getBossName() + "\n");
            }
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void exitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void addAction(ActionEvent event) {
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
    private void deleteAction(ActionEvent event) {
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

    @FXML
    private void aboutAction(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Example JavaFXML application");
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        bossNameCol.setCellValueFactory(new PropertyValueFactory<>("bossName"));
        personnelCol.setCellValueFactory(new PropertyValueFactory<>("personnel"));
    }

    public void setMainApp(TableFXML mainApp) {
        this.mainApp = mainApp;
        table.setItems(mainApp.getData());
    }

}
