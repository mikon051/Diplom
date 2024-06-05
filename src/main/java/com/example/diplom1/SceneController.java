package com.example.diplom1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SceneController implements Initializable {
    Stage stage;
    Parent root;

    @FXML
    private Label lbl1,lbl2;

    @FXML
    private Button btn1,btn2,btn3;

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {

        Object source = event.getSource();
        if (source instanceof Button){
            Button sourceButton = (Button) source;
            if(sourceButton.equals(btn1)){
                stage = (Stage) btn1.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            } else if  (sourceButton.equals(btn2)) {
                stage = (Stage) btn2.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            }
            else{
                stage = (Stage) btn3.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Diplom.fxml"));
            }
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}