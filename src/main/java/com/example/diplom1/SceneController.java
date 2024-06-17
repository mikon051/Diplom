package com.example.diplom1;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.tools.javac.Main;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import javax.swing.*;

import static com.example.diplom1.PIDGraph.*;


public class SceneController implements Initializable {

    Stage stage = new Stage();
    Parent root;

    @FXML
    private TextArea textFlow;
    @FXML
    private TextField TextK0, TextT, TextTay, TextP, TextI, TextD, TextDis, TextQuest, TextError, TextTime, TextIkr, ONRTextP, ONRTextI, ONRTextD;
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
    private Button MainMenu, AboutWorkButton, Back, Back1, ProcessItem, TempItem, DiagnostItem, InfoItem, StrucACR, Math, Exit1, MainMath, ONR, OnDiagnostScene, OnDiagnost, Diagnost1, next, Graph;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {


        var source = event.getSource();

//Отвечает переход на другую сцену после нажатия кнопки
        if (source instanceof Button sourceButton) {
            Window window = sourceButton.getScene().getWindow();
            if (sourceButton.getScene().getWindow() instanceof Stage) {
                Stage currentStage = (Stage) window;
                if (sourceButton.equals(MainMenu)) {
                    currentStage.close();
                    root = FXMLLoader.load(getClass().getResource("SceneMenuMain.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
                else if (sourceButton.equals(AboutWorkButton)) {
                    currentStage.close();
                    root = FXMLLoader.load(getClass().getResource("AboutWork.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
                else if (sourceButton.equals(Graph)) {
                    LineChart<Number, Number> lineChart = DispersionGrowthSignalGenerator();
                    Scene scene = new Scene(lineChart, 800, 600);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                }
                else if (sourceButton.equals(ONR)) {
                    String StringK0 = this.TextK0.getText();
                    double K0 = Double.parseDouble(StringK0);
//           TextK0.clear();
//
                    String StringT = this.TextT.getText();
                    double T = Double.parseDouble(StringT);
//           TextT.clear();

                    String StringTay = this.TextTay.getText();
                    double Tay = Double.parseDouble(StringTay);

                    this.TextP.setText(String.valueOf(1/K0));
                    this.TextI.setText(String.valueOf(T));
                    this.TextD.setText(String.valueOf(Tay/2));
                }
                else if (sourceButton.equals(MainMath)) {


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
                    this.TextIkr.setText(String.valueOf(IntegralKr));
                    IntegralKr = 0;
                    String StringQuest = this.TextQuest.getText();
                    double Quest = Double.parseDouble(StringQuest);

                    String StringTime = this.TextTime.getText();
                    double Time = Double.parseDouble(StringTime);

                    LineChart<Number, Number> lineChart = drawGraph(miniPID, K0, T, Tay, Quest, Time, Dis);

                    Scene scene = new Scene(lineChart, 800, 600);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(Exit1)) {
                    currentStage.close();
                } else if (sourceButton.equals(Back)) {

                    currentStage.close();
                } else if (sourceButton.equals(Back1)) {
                    currentStage.close();
                    root = FXMLLoader.load(getClass().getResource("SceneMenuMain.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }
                else if (sourceButton.equals(next)) {
                    currentStage.close();
                    root = FXMLLoader.load(getClass().getResource("AboutDiagnost2.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                }

            } else {
                if (sourceButton.equals(ProcessItem)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("Process.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(TempItem)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("TempPr.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(DiagnostItem)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("Diagnost.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(InfoItem)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("Info.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(Math)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("Synthesis.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(StrucACR)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("StrukcherACR.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(StrucACR)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("StrukcherACR.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } else if (sourceButton.equals(Diagnost1)) {
                    stage.close();
                    root = FXMLLoader.load(getClass().getResource("AboutDiagnost.fxml"));
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();}

                    else if (sourceButton.equals(OnSynthesis)) {
                        stage.close();
                        root = FXMLLoader.load(getClass().getResource("Synthesis.fxml"));
                        Scene scene = new Scene(root);
                        stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                    } else if (sourceButton.equals(OnDiagnostScene)) {
                        stage.close();
                        root = FXMLLoader.load(getClass().getResource("Diagnostica.fxml"));
                        Scene scene = new Scene(root);
                        stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                    }
                }

            }
        }




    public void init(MouseEvent mouseEvent) {
        AboutWorkButton.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            System.out.println("Mouse entered!");
            textFlow.setText("Описание процесса и то что включает в себя программа");

        });
        AboutWorkButton.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        ProcessItem.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("Описание технологии процесса");
        });
        ProcessItem.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        TempItem.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("Описание температурных зон внутри печи");
        });
        TempItem.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        DiagnostItem.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("Описание диномической модели печи");
        });
        DiagnostItem.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        InfoItem.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("Описание информацинной схемы печи");
        });
        InfoItem.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        StrucACR.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("Подробнее о структуре АСР");
        });
        StrucACR.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        Math.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("Расчет объекта и ПИД регулятора");
        });
        Math.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        OnDiagnostScene.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("К режиму диагностики");
        });
        OnDiagnostScene.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });

        Exit1.addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            textFlow.setText("Выход их программы");
        });
        Exit1.setOnMouseExited(event -> {
            // Скрываем текст при уходе
            textFlow.clear();
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
