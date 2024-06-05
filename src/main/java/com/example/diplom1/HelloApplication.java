package com.example.diplom1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        primaryStage.setTitle("Swich");
        primaryStage.setScene(new Scene(root, 750, 500));
        primaryStage.show();
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