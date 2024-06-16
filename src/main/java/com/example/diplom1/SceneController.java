package com.example.diplom1;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.tools.javac.Main;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import static com.example.diplom1.PIDGraph.*;


public class SceneController implements Initializable {

  Stage stage =new Stage();
  Parent root;

  @FXML
  private TextField TextK0, TextT, TextTay, TextP, TextI, TextD, TextDis, TextQuest, TextError, TextTime ;
  @FXML
  private Label Menu;
  @FXML
  private Label MenuClose;
  @FXML
  private AnchorPane slider;
  @FXML
  private Label lbl1, lbl2;
  @FXML
  private MenuButton OnObject, OnSynthesis;
  @FXML
  private Button MainMenu, AboutWorkButton, Back,ProcessItem, TempItem, DiagnostItem,InfoItem, StrucACR, Math,Exit1, MainMath;
  @FXML
  private void handleButtonAction(ActionEvent event) throws Exception {


    var source = event.getSource();

//Отвечает переход на другую сцену после нажатия кнопки
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
       }else if (sourceButton.equals(MainMath)) {

           // Создаем сцену и добавляем график на нее

           String StringK0 = this.TextK0.getText();
           double K0 = Double.parseDouble(StringK0);
//           TextK0.clear();
//
           String StringT = this.TextT.getText();
           double T = Double.parseDouble(StringT);
//           TextT.clear();

           String StringTay = this.TextTay.getText();
           double Tay = Double.parseDouble(StringTay);
//           TextTay.clear();

           String StringP = this.TextP.getText();
           double P = Double.parseDouble(StringP);
//           TextP.clear();

           String StringI = this.TextI.getText();
           double I = Double.parseDouble(StringI);
//           TextI.clear();

           String StringD = this.TextD.getText();
           double D = Double.parseDouble(StringD);
//           TextD.clear();

           MiniPID miniPID = createMiniPID(P, I, D);

           String StringDis = this.TextDis.getText();
           double Dis = Double.parseDouble(StringDis);

           this.TextError.setText(String.valueOf(TargetActual));

           String StringQuest = this.TextQuest.getText();
           double Quest = Double.parseDouble(StringQuest);

           String StringTime = this.TextTime.getText();
           double Time = Double.parseDouble(StringTime);

//           ObjectACR F = new ObjectACR(K0, T, Tay);
//           double object = F.formula();





           LineChart<Number, Number> lineChart = drawGraph(miniPID, K0, Tay, Quest, Time, Dis);

           Scene scene = new Scene(lineChart, 800, 600);
           stage = new Stage();
           stage.setScene(scene);
           stage.show();
       }
       else if (sourceButton.equals(OnSynthesis)) {
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

       else if (sourceButton.equals(Exit1)) {
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

       if (sourceButton.equals(Math)) {
         stage.close();
         root = FXMLLoader.load(getClass().getResource("Synthesis.fxml"));
         Scene scene = new Scene(root);
         stage = new Stage();
         stage.setScene(scene);
         stage.show();
       } else
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

