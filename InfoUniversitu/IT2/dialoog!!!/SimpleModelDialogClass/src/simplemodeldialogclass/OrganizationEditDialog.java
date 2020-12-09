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
    private TextField subject1Edit;
    private TextField subject2Edit;
    private TextField subject3Edit;

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

    private void createSubject1Change() {
        Label subject1 = new Label("Subject1:");
        subject1.setFont(font);
        root.add(subject1, 0, 1);
        subject1Edit = new TextField(org.getSubject1());
        root.add(subject1Edit, 1, 1);
    }

    private void createSubject2Change() {
        Label subject2 = new Label("Subject2:");
        subject2.setFont(font);
        root.add(subject2, 0, 2);
        subject2Edit = new TextField(org.getSubject2());
        root.add(subject2Edit, 1, 2);
    }

    private void createSubject3Change() {
        Label subject3 = new Label("Subject3:");
        subject3.setFont(font);
        root.add(subject3, 0, 3);
        subject3Edit = new TextField(org.getSubject3());
        root.add(subject3Edit, 1, 3);
    }

    private void createButtons() {
        ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
        dialog.setResultConverter((ButtonType b) -> {
            if (b == buttonTypeOk) {
                if (isInputValid()) {
                    handleOk();
                    return org;
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
        createSubject1Change();
        createSubject2Change();
        createSubject3Change();
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
        org.setSubject1(subject1Edit.getText());
        org.setSubject2(subject2Edit.getText());
        org.setSubject3(subject3Edit.getText());
    }

}
