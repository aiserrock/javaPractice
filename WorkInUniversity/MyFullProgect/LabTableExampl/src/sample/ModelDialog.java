package sample;

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
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ModelDialog {

        private Model model;

        private TextField nameEdit;
        private Spinner<Integer> ageEdit;
        private ComboBox kindEdit;

        private Font font;
        private GridPane root;
        private Dialog<Model> dialog;

        private void createNameText() {
            Label nameModel = new Label("Name:");
            nameModel.setFont(font);
            root.add(nameModel, 0, 0);
            nameEdit = new TextField();
            nameEdit.setText(model.getName());
            root.add(nameEdit, 1, 0);
        }

        private void createComboBox() {
            Label kindModel = new Label("Kind:");
            kindModel.setFont(font);
            root.add(kindModel, 0, 2);
            kindEdit = new ComboBox();
            kindEdit.getItems().addAll(
                    "Cat",
                    "Dog",
                    "Tortoise",
                    "Rhino"
            );
            kindEdit.setValue(model.getKind());
            root.add(kindEdit, 1, 2);
        }

        private void createSpinner() {
            Label ageModel = new Label("Age:");
            ageModel.setFont(font);
            root.add(ageModel, 0, 1);
            ageEdit = new Spinner(1, 100, model.getAge());
            root.add(ageEdit, 1, 1);
        }

        private void createButtons() {
            ButtonType buttonTypeOk = new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
            ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            dialog.getDialogPane().getButtonTypes().add(buttonTypeCancel);
            dialog.setResultConverter((ButtonType b) -> {
                if (b == buttonTypeOk) {
                    if (isInputValid()) {
                        handleOk();
                        Model newModel = new Model(nameEdit.getText(), ageEdit.getValue(),kindEdit.getValue().toString());
                        return newModel;
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Data entry error");
                        alert.setHeaderText("Name entry error");
                        alert.setContentText("\"The name of pet consists of letters, numbers, spaces, +, -!!!\\n \"");
                        alert.showAndWait();
                    }
                }
                return null;
            });
        }

        public ModelDialog(Model model, String title) {
            this.model = model;
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
            dialog.getDialogPane().setContent(root);
            createButtons();
        }
        public Dialog<Model> getDialog() {
            return dialog;
        }

        private boolean isInputValid() {
            return nameEdit.getText().matches("[a-zA-Z0-9&\\-\\+ ]+");
        }

        private void handleOk() {
            model.setName(nameEdit.getText());
            model.setAge(ageEdit.getValue());
            model.setKind(kindEdit.getValue().toString());
        }


}
