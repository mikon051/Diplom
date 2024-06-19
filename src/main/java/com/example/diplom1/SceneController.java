package com.example.diplom1;

import java.awt.*;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import com.sun.tools.javac.Main;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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
    private LineChart lineChart;
    @FXML
    private TableView<TextData> tableView;
    @FXML
    private TableColumn<String, TextData> error, krView, trueFalse;
    @FXML
    private TextArea textFlow;
    @FXML
    private TextField TextK0, TextT, TextTay, TextP, TextI, TextD, TextDis, TextQuest, TextError, TextTime, TextIkr;
    @FXML
    private TextField  alpha,  size,  discret,  start,  SKO,  timeWhenShift,  outlierVariance,  outlierProbability,
            shiftPar, dispersOutlierProbability, Tmax, Tmin, deltaT;
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
    private Button MainMenu, AboutWorkButton, Back, Back1, ProcessItem, TempItem, DiagnostItem, InfoItem, StrucACR,
            Math, Exit1, MainMath, ONR, OnDiagnostScene, OnDiagnost, Diagnost1, next, Graph, DiagnosticMenu, Check;

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

                    String StringAlpha = this.alpha.getText();
                    double alphaAccept = Double.parseDouble(StringAlpha);

                    String StringSize = this.size.getText();
                    double sizeAccept = Double.parseDouble(StringSize);

                    String StringDiscret = this.discret.getText();
                    double discretAccept = Double.parseDouble(StringDiscret);

                    String StringStart = this.start.getText();
                    double startAccept = Double.parseDouble(StringStart);

                    String StringSKO = this.SKO.getText();
                    double SKOAccept = Double.parseDouble(StringSKO);

                    String StringTimeWhenShift = this.timeWhenShift.getText();
                    double timeWhenShiftAccept = Double.parseDouble(StringTimeWhenShift);

                    String StringOutlierVariance = this.outlierVariance.getText();
                    double outlierVarianceAccept = Double.parseDouble(StringOutlierVariance);

                    String StringOutlierProbability = this.outlierProbability.getText();
                    double outlierProbabilityAccept = Double.parseDouble(StringOutlierProbability);

                    String StringShiftPar = this.shiftPar.getText();
                    double shiftParAccept = Double.parseDouble(StringShiftPar);

                    String StringDispersOutlierProbability = this.dispersOutlierProbability.getText();
                    double DispersOutlierProbabilityAccept = Double.parseDouble(StringDispersOutlierProbability);

                    LineChart<Number, Number> lineChart = dispersionGrowthSignalGenerator(alphaAccept, sizeAccept, discretAccept,
                            startAccept, SKOAccept, 0, timeWhenShiftAccept, outlierVarianceAccept, outlierProbabilityAccept, shiftParAccept
                            , DispersOutlierProbabilityAccept);
                    Scene scene = new Scene(lineChart, 800, 600);
                    stage = new Stage();
                    stage.setScene(scene);
                    stage.show();

                }

                else if (sourceButton.equals(Check)) {
                    double sum = 0;
                    int count = 0;
                    String StringTmax = this.Tmax.getText();
                    double Tmax = Double.parseDouble(StringTmax);

                    String StringTmin = this.Tmin.getText();
                    double Tmin = Double.parseDouble(StringTmin);

                    String StringDeltaT = this.deltaT.getText();
                    double deltaT = Double.parseDouble(StringDeltaT);

                    XYChart.Series<Number, Number> series = getLineChart2().getData().get(0); // assuming you have only one series
                    //Расчет среднего арефметического по выборке lineChart
                    for (XYChart.Data<Number, Number> data : series.getData()) {
                        sum += data.getYValue().doubleValue();
                        count++;
                    }
                    double average = sum / count;



                    for (XYChart.Data<Number, Number> data : series.getData()) {
                        if (data.getYValue().doubleValue() > Tmax) {
                            ObservableList<TextData> dataView = FXCollections.observableArrayList(
                                    new TextData("Обрыв в канале измерения", "Нарушение верхней технологической нормы", "Да"));
                            // Set the data to the table view
                            tableView.setItems(dataView);
                        } else {
                            ObservableList<TextData> dataView = FXCollections.observableArrayList(
                                    new TextData("Обрыв в канале измерения", "Нарушение верхней технологической нормы", " нет"));
                            // Set the data to the table view

                        }

                        if (data.getYValue().doubleValue() < Tmin) {
                            ObservableList<TextData> dataView = FXCollections.observableArrayList(
                                    new TextData("Обрыв в канале измерения", "Нарушение нижней технологической нормы, ", "Да"));
                            // Set the data to the table view
                            tableView.setItems(dataView);

                        } else {
                            ObservableList<TextData> dataView = FXCollections.observableArrayList(
                                    new TextData("Обрыв в канале измерения", "Нарушение нижней технологической нормы", " нет"));
                            // Set the data to the table view
                            tableView.setItems(dataView);
                        }
                        if ((data.getYValue().doubleValue() < average - 50) || (data.getYValue().doubleValue() > average + 50)) {
                            ObservableList<TextData> dataView = FXCollections.observableArrayList(
                                    new TextData("Нарушение контактов термопары, возможное обгарание контактов", "Нарушение  технологических норм наличие выбросов в измеряемом сигнале", " Да"));
                            // Set the data to the table view
                            tableView.setItems(dataView);

                        } else {
                            ObservableList<TextData> dataView = FXCollections.observableArrayList(
                                    new TextData("Нарушение контактов термопары, возможное обгарание контактов", "Нарушение  технологических норм наличие выбросов в измеряемом сигнале", "нет"));
                            // Set the data to the table view
                            tableView.setItems(dataView);
                        }

                    }


                    TableColumn<TextData, String> error = new TableColumn<>("error ");
                    TableColumn<TextData, String> krView = new TableColumn<>("krView ");
                    TableColumn<TextData, String> trueFalse = new TableColumn<>("trueFalse");

                    error.setCellValueFactory(new PropertyValueFactory<>(StringTmax));
                    krView.setCellValueFactory(new PropertyValueFactory<>(StringTmin));
                    trueFalse.setCellValueFactory(new PropertyValueFactory<>(StringDeltaT));

                    tableView.getColumns().addAll(error, krView, trueFalse);

                    error.setCellValueFactory(cellData -> cellData.getValue().text1Property());
                    krView.setCellValueFactory(cellData -> cellData.getValue().text2Property());
                    trueFalse.setCellValueFactory(cellData -> cellData.getValue().text3Property());

                    StackPane root = new StackPane();
                    root.getChildren().add(tableView);

                    Scene scene = new Scene(root, 600, 800);
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

            } else if (sourceButton.equals(DiagnosticMenu)) {
                stage.close();
                root = FXMLLoader.load(getClass().getResource("DiagnosticMenu.fxml"));
                Scene scene = new Scene(root);
                stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }
            else {
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
                    root = FXMLLoader.load(getClass().getResource("Dinamic.fxml"));
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


//Анимации наведения мышки

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
