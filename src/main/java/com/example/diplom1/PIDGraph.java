package com.example.diplom1;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class PIDGraph {
    public static LineChart<Number, Number> drawGraph(MiniPID miniPID) {
        LineChart<Number, Number> lineChart = getLineChart();
        XYChart.Series seriesActual = getCustomSeries("seriesActual");
        XYChart.Series seriesTarget = getCustomSeries("seriesTarget");

        double target = 100;
        double actual = 0;
        double output = 0;

        miniPID.setSetpoint(target);

        System.err.printf("Target\tActual\tOutput\tError\n");
//TODO:Добавить дескретность как поле через i, так же выводить ошибку Error
        for (int i = 0; i < 100; i++) {
            output = miniPID.getOutput(actual, target);
            actual = actual + output;

            addPoints(i, actual, seriesActual);
            addPoints(i, target, seriesTarget);
        }

        lineChart.getData().add(seriesActual);
        lineChart.getData().add(seriesTarget);

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

    public static MiniPID createMiniPID(double P, double I, double D, double F) {
        MiniPID miniPID = new MiniPID(P, I, D, F);
        miniPID.setOutputLimits(100);
        miniPID.setMaxIOutput(2);
        miniPID.setOutputRampRate(3);
        miniPID.setOutputFilter(.3);
        miniPID.setSetpointRange(40);
        return miniPID;
    }

    public static void addPoints(int X, double Y, XYChart.Series series) {
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
