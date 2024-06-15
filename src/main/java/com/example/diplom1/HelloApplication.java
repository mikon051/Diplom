package com.example.diplom1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;



public class HelloApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("TitulScene.fxml"));
        primaryStage.setTitle("Диплом");
        primaryStage.setScene(new Scene(root, 1200, 678));
        primaryStage.show();
//        System.err.printf("%3.2f\t%3.2f\t%3.2f\t%3.2f\n", target, actual, output, (target-actual));
    }

    public static void main(String[] args) {

        launch(args);
    }

}


//    public class Main extends Application {
//
//        @Override
//        public void start(Stage stage) {
//        try {
//
//            Parent root = FXMLLoader.load(getClass().getResource("Diplom.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//        }
//    }