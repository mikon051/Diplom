package com.example.diplom1;

import java.net.URL;
import java.util.Arrays;
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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class SceneController implements Initializable {

  Stage stage =new Stage();
  Parent root;

  @FXML
  private Label lbl1, lbl2;

  @FXML
  private Button btn1, btn2, btn3;

  @FXML
  private void handleButtonAction(ActionEvent event) throws Exception {

    var source = event.getSource();
    if (source instanceof Button sourceButton) {
      Stage window = (Stage) sourceButton.getScene().getWindow();
      if (sourceButton.equals(btn1)) {
        window.close();
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
      } else if (sourceButton.equals(btn2)) {
        window.close();
        root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();

        stage.setScene(scene);
        stage.show();
//        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
      } else {
        window.close();
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
//        stage = (Stage) btn3.getScene().getWindow();
//        root = FXMLLoader.load(getClass().getResource("Diplom.fxml"));
      }
    }

//    Scene scene = new Scene(root);
//    stage.setScene(scene);
//    stage.show();
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // TODO
  }
}