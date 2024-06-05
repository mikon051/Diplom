package com.example.diplom1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.Buffer;



public class SwitchSceneA extends Application {

    private Stage stage1;
    private Scene scene1;
    private VBox vbox1;
    private Button button1;

    private Scene scene2;
    private VBox vbox2;
    private Button button2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage1 = primaryStage;
        stage1.setTitle("Cool!");
        primaryStage.setScene(new Scene(root1, 750, 500));

        stage1.show();
    }
    private Scene createSceneOne() throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        button1 = new Button();
        scene1 = new Scene(root1,750, 500);
        vbox1 = new VBox(button1);
        button1.setOnAction(e -> switchScene(scene2));


        return scene1;
    }

    private Scene createSceneTwo() throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        button2 = new Button("Стартище");
        scene2 = new Scene(root2);

        button2.setOnAction(e -> switchScene(scene1));
        vbox2 = new VBox(button1);

        return scene2;
    }

    public void switchScene(Scene scene){
        stage1.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }

}