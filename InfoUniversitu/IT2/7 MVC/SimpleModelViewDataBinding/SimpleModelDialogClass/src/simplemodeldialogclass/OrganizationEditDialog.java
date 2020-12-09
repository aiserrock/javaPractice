/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplemodeldialogclass;

import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author nadezhda
 */
public class OrganizationEditDialog {

    private Organization org;
    private TextField nameEdit;
    private Spinner<Integer> personnelEdit;
    private ComboBox holidayEdit;
    private DatePicker dateEdit;
    private Spinner<Double> drinkVolumeEdit;
    private Font font;
    private GridPane root;
    private Dialog<Organization> dialog;

    private void createNameText() {
        Label nameOrg = new Label("Name:");
        nameOrg.setFont(font);
        root.add(nameOrg, 0, 0);
        nameEdit = new TextField();
        nameEdit.setText(org.getName());
        root.add(nameEdit, 1, 0);
    }

    private void createDatePicker() {
        Label dateOrg = new Label("Date:");
        dateOrg.setFont(font);
        root.add(dateOrg, 0, 3);
        dateEdit = new DatePicker(org.getDate());
        root.add(dateEdit, 1, 3);
    }

    private void createComboBox() {
        Label holidayOrg = new Label("Holiday:");
        holidayOrg.setFont(font);
        root.add(holidayOrg, 0, 2);
        holidayEdit = new ComboBox();
        holidayEdit.getItems().addAll(
                "New Year",
                "Defender's Day",
                "International Women's Day",
                "Boss birthday"
        );
        holidayEdit.setValue(org.getHoliday());
        root.add(holidayEdit, 1, 2);
    }

    private void createSpinner() {
        Label personnelOrg = new Label("Personnel:");
        personnelOrg.setFont(font);
        root.add(personnelOrg, 0, 1);
        personnelEdit = new Spinner(1, 100, org.getPersonnel());
        //personnelEdit.setEditable(true);
        root.add(personnelEdit, 1, 1);
        Label drinkVolumeOrg = new Label("Drink volume:");
        drinkVolumeOrg.setFont(font);
        root.add(drinkVolumeOrg, 0, 4);
        drinkVolumeEdit = new Spinner(0, 200, org.getDrinkVolume(), 0.1);
        drinkVolumeEdit.setEditable(true);
        root.add(drinkVolumeEdit, 1, 4);

    }

    private void createButtons() {
        ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
        dialog.setResultConverter((ButtonType b) -> {
            if (b == buttonTypeOk) {
                if (isInputValid() == true) {
                    handleOk();
//                        Organization newOrg = new Organization(nameEdit.getText(), personnelEdit.getValue(),
//                                holidayEdit.getValue().toString(), dateEdit.getValue(), drinkVolumeEdit.getValue());
//                        return newOrg;
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Data entry error");
                    alert.setHeaderText("Name entry error");
                    alert.setContentText("\"The name of organization consists of letters, numbers, spaces, +, -!!!\\n \"");
                    alert.showAndWait();
                }
            }
            return null;
        });
    }

    public OrganizationEditDialog(Organization org, String title) {
        this.org = org;
        dialog = new Dialog<>();
        dialog.setTitle(title);
        dialog.setHeaderText("This is a custom dialog. Enter info and press Ok.");
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        font = Font.font("Tahoma", FontWeight.NORMAL, 20);
        createNameText();
        createSpinner();
        createComboBox();
        createDatePicker();
        dialog.getDialogPane().setContent(root);
        createButtons();        
    }
    public Dialog<Organization> getDialog() {
        return dialog;
    }

    private boolean isInputValid() {
        return nameEdit.getText().matches("[a-zA-Z0-9&\\-\\+ ]+");
    }

    private void handleOk() {
        org.setName(nameEdit.getText());
        org.setPersonnel(personnelEdit.getValue());
        org.setHoliday(holidayEdit.getValue().toString());
        org.setDate(dateEdit.getValue());
        org.setDrinkVolume(drinkVolumeEdit.getValue());
    }

}
