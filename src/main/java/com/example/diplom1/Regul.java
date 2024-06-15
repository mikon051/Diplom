//package com.example.diplom1;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.chart.LineChart;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.chart.XYChart;
//import javafx.stage.Stage;
//
//public class Regul extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//
//        LineChart<Number, Number> lineChart = drawGraph();
//
//        // Создаем сцену и добавляем график на нее
//        Scene scene = new Scene(lineChart, 800, 600);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//    public LineChart<Number, Number> drawGraph() {
//        LineChart<Number, Number> lineChart = getLineChart();
//        XYChart.Series seriesActual = getCustomSeries("seriesActual");
//        XYChart.Series seriesTarget = getCustomSeries("seriesTarget");
//
//        ObjectACR objectACR = new ObjectACR(3,3.9,3.3);
//        double F = objectACR.formula();
//
//        MiniPID miniPID = createMiniPID(F);
//
//        double target = 100;
//        double actual = 0;
//        double output = 0;
//
//
//        miniPID.setSetpoint(target);
//
//        System.err.printf("Target\tActual\tOutput\tError\n");
//
//        for (int i = 0; i < 100; i++) {
//            output = miniPID.getOutput(actual, target);
//            actual = actual + output;
//
//            addPoints(i, actual, seriesActual);
//            addPoints(i, target, seriesTarget);
//        }
//
//        lineChart.getData().add(seriesActual);
//        lineChart.getData().add(seriesTarget);
//
//        return lineChart;
//    }
//
//    public NumberAxis createAxis(String label) {
//        NumberAxis axis = new NumberAxis();
//        axis.setLabel(label);
//        return axis;
//    }
//
//    public XYChart.Series createSeries(String name) {
//        XYChart.Series series = new XYChart.Series();
//        series.setName(name);
//        return series;
//    }
//
//    public MiniPID createMiniPID(ObjectACR F) {
//        MiniPID miniPID = new MiniPID(0.25, 0.01, 0.4, F);
//        miniPID.setOutputLimits(10);
//        miniPID.setSetpointRange(40);
//        return miniPID;
//    }
//
//    public static void addPoints(int X, double Y, XYChart.Series series) {
//        XYChart.Data data = new XYChart.Data(X, Y);
//        // Добавляем точки на график
//        series.getData().add(data);
//    }
//    public XYChart.Series getCustomSeries(String name) {
//        XYChart.Series series = createSeries(name);
//        return series;
//    }
//
//    public LineChart<Number, Number> getLineChart () {
//        NumberAxis xAxis = createAxis("X Axis");
//        NumberAxis yAxis = createAxis("Y Axis");
//
//        return new LineChart<>(xAxis, yAxis);
//    }
//}