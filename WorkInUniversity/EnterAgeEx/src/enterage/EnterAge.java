package enterage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.scene.control.Spinner;
//import javafx.scene.control.SpinnerValueFactory;
public class EnterAge extends Application {

    GridPane root;
    Text actiontarget;
    TextField nameTextField;
    TextField valueKkal;
    Button btn;

    public void initRootLayout() {
        root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Calculation of kkal");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Name:");
        root.add(userName, 0, 1);
        nameTextField = new TextField();
        root.add(nameTextField, 1, 1);

        Label userYear = new Label("Massa");
        root.add(userYear, 0, 2);
        valueKkal = new TextField();
        root.add(valueKkal, 1, 2);

        btn = new Button("Calculation");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        root.add(hbBtn, 1, 4);

        actiontarget = new Text();

        root.add(actiontarget, 1, 6);
        btn.setOnAction((ActionEvent e) -> {
            calculateKkal();
        });
    }

    private void calculateKkal() {
        String name = nameTextField.getText();
        String kkal = valueKkal.getText();
        if (name.matches("[a-z]+")){
            if (kkal.matches("[0-9]+")) {
            double kkalm = 3.01*Integer.parseInt(kkal);
//            Map vibor = new HashMap<String,Integer>();
//            vibor.put("indeika",198);
//            vibor.put("omlet",209);
//            vibor.put("vafli",543);
//            vibor.put("vishnya",52);
//            vibor.put("ogyrci",13);
//            vibor.put("kolbaska",301);
//            Set set = vibor.entrySet();
//            Iterator iterator = set.iterator();
//            while(iterator.hasNext()) {
//            if(name ==(vibor.Entry)iterator.next()){
//                
//            }
//            }
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText(Double.toString(kkalm) + "  kkal kolbaska");



        }
            else{
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("Error Massa");
                    
                    
        }
        }
        else{
           actiontarget.setFill(Color.FIREBRICK);
           actiontarget.setText("Error Name"); 
        }
        
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kkal");
        initRootLayout();
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
