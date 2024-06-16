package com.example.diplom1;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;



public class PIDGraph {
    public static double actual = 0;

    public static double TargetActual;

    public static double getTargetActual() {
        return TargetActual;
    }

    public static LineChart<Number, Number> drawGraph(MiniPID miniPID, double K0, double Tay, double target, double time, double Dis) {
        LineChart<Number, Number> lineChart = getLineChart();
        XYChart.Series seriesActual = getCustomSeries("seriesActual");
        XYChart.Series seriesTarget = getCustomSeries("seriesTarget");

        miniPID.setSetpoint(target);
        double output = 0;
        System.err.printf("Target\tActual\tOutput\tError\n");

        addPoints(0, 0, seriesActual);
        addPoints(0, target, seriesTarget);
        for (double i = Tay ; i < time; i=i+Dis) {

            System.err.printf("%3.2f\t%3.2f\t%3.2f\t%3.2f\n", target, actual, output, (target-actual));
            output = miniPID.getOutput(actual, target, K0);
            actual = actual + output;

            addPoints(i, actual, seriesActual);
            addPoints(i, target, seriesTarget);
        }

        lineChart.getData().add(seriesActual);
        lineChart.getData().add(seriesTarget);
        TargetActual = actual-target;
        return lineChart;
    }

    public static NumberAxis createAxis(String label) {
        NumberAxis axis = new NumberAxis();
        axis.setLabel(label);
        return axis;
    }

    public static XYChart.Series createSeries(String name) {
        XYChart.Series series = new XYChart.Series();
        series.setName(name);


        return series;
    }



    public static MiniPID createMiniPID(double P, double I, double D) {
//        MyProcessObject processObject = new MyProcessObject(5);
//        ObjectPID objectPID = new ObjectPID( P,  I,  D,  processObject);
//        objectPID.setSetpoint(10);
//        objectPID.control();
        //        return objectPID;
        MiniPID miniPID = new MiniPID(P, I, D);
        miniPID.setOutputLimits(10);
        miniPID.setMaxIOutput(10);
        miniPID.setOutputRampRate(3);
        miniPID.setOutputFilter(3);
        miniPID.setSetpointRange(5);
        return miniPID;

    }

    public static void addPoints(double X, double Y, XYChart.Series series) {
        XYChart.Data data = new XYChart.Data(X, Y);
        // Добавляем точки на график

        series.getData().add(data);

    }

    public static XYChart.Series getCustomSeries(String name) {
        XYChart.Series series = createSeries(name);

        return series;
    }

    public static LineChart<Number, Number> getLineChart() {
        NumberAxis xAxis = createAxis("X Axis");
        NumberAxis yAxis = createAxis("Y Axis");

        return new LineChart<>(xAxis, yAxis);
    }
}
