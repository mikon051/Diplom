package com.example.diplom1;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SceneController implements Initializable {

  Stage stage =new Stage();
  Parent root;

  @FXML
  private Label lbl1, lbl2, Menu, MenuClose;
  @FXML
  private MenuButton OnObject, OnSynthesis;
  @FXML
  private Button MainMenu, Exit, AboutWorkButton, Back,ProcessItem, TempItem, DiagnostItem,InfoItem;
  @FXML
  private void handleButtonAction(ActionEvent event) throws Exception {

    var source = event.getSource();

    if (source instanceof Button sourceButton) {
      Stage window = (Stage) sourceButton.getScene().getWindow();
      if (sourceButton.equals(MainMenu)) {
        window.close();
        root = FXMLLoader.load(getClass().getResource("SceneMenuMain.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
      } else if (sourceButton.equals(AboutWorkButton)) {
        window.close();
        root = FXMLLoader.load(getClass().getResource("AboutWork.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();

        stage.setScene(scene);
        stage.show();
      } else if (sourceButton.equals(OnSynthesis)) {
        window.close();
        root = FXMLLoader.load(getClass().getResource("Synthesis.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();

      } else if (sourceButton.equals(OnObject)) {
        window.close();
        root = FXMLLoader.load(getClass().getResource("Object.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();

      }

      if (sourceButton.equals(Exit)) {
        window.close();
      }
      if (sourceButton.equals(Back)) {

        window.close();
        root = FXMLLoader.load(getClass().getResource("SceneMenuMain.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
      }

      if (sourceButton.equals(ProcessItem)) {
        window.close();
        root = FXMLLoader.load(getClass().getResource("Process.fxml"));
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
      }




    }
  }
//  private void onMenu(ActionEvent event) throws Exception{
//    var source = event.getSource();
//    if (source instanceof MenuItem sourceButton){
//      if (sourceButton.equals(menu1)) {
//
//        root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));K
//        Scene scene = new Scene(root);
//        stage = new Stage();
//
//        stage.setScene(scene);
//        stage.show();
//      }
//    }
//  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }
  }
