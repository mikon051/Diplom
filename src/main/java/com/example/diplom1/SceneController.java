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
import javafx.stage.Window;

public class SceneController implements Initializable {

  Stage stage =new Stage();
  Parent root;

  @FXML
  private Label lbl1, lbl2, Menu, MenuClose;
  @FXML
  private MenuButton OnObject, OnSynthesis;
  @FXML
  private Button MainMenu, Exit, AboutWorkButton, Back,ProcessItem, TempItem, DiagnostItem,InfoItem, StrucACR;
  @FXML
  private void handleButtonAction(ActionEvent event) throws Exception {

    var source = event.getSource();

    if (source instanceof Button sourceButton) {
      Window window = sourceButton.getScene().getWindow();
     if(sourceButton.getScene().getWindow() instanceof Stage) {
       Stage currentStage = (Stage) window;
       if (sourceButton.equals(MainMenu)) {
         currentStage.close();
         root = FXMLLoader.load(getClass().getResource("SceneMenuMain.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       } else if (sourceButton.equals(AboutWorkButton)) {
         currentStage.close();
         root = FXMLLoader.load(getClass().getResource("AboutWork.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();

         stage.setScene(scene);
         stage.show();
       } else if (sourceButton.equals(OnSynthesis)) {
         currentStage.close();
         root = FXMLLoader.load(getClass().getResource("Synthesis.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();

       } else if (sourceButton.equals(OnObject)) {
         currentStage.close();
         root = FXMLLoader.load(getClass().getResource("Object.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();

       }

       else if (sourceButton.equals(Exit)) {
         currentStage.close();
       }
       else if (sourceButton.equals(Back)) {

         currentStage.close();
         root = FXMLLoader.load(getClass().getResource("SceneMenuMain.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       }
     }else {
       if (sourceButton.equals(ProcessItem)) {
         stage.close();
         root = FXMLLoader.load(getClass().getResource("Process.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       } else
       if (sourceButton.equals(TempItem)) {
         stage.close();
         root = FXMLLoader.load(getClass().getResource("TempPr.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       }
       else

     if (sourceButton.equals(DiagnostItem)) {
         stage.close();
         root = FXMLLoader.load(getClass().getResource("Diagnost.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       }
     else

       if (sourceButton.equals(InfoItem)) {
         stage.close();
         root = FXMLLoader.load(getClass().getResource("Info.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       }
       else

       if (sourceButton.equals(StrucACR)) {
         stage.close();
         root = FXMLLoader.load(getClass().getResource("StrukcherACR.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       }
       }



    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }
  }
