package com.example.diplom1;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import org.apache.commons.math3.complex.Complex;

import static com.almasb.fxgl.core.math.FXGLMath.getRandom;


public class PIDGraph {


    public static double TargetActual;
    public static double IntegralKr;

    public static double getTargetActual() {
        return TargetActual;
    }

    public static LineChart<Number, Number> drawGraph(MiniPID miniPID,double T , double K0, double Tay, double target, double time, double Dis) {
        LineChart<Number, Number> lineChart = getLineChart();
        XYChart.Series seriesActual = getCustomSeries("seriesActual");
        XYChart.Series seriesTarget = getCustomSeries("seriesTarget");

        ObjectACR objectACR = new ObjectACR(K0, T, Tay);
        double actual = 0;
        double output = 0;
        double object =  objectACR.func();

        miniPID.setSetpoint(target);


        System.err.printf("Target\tActual\tOutput\tError\n");

        addPoints(0, 0, seriesActual);
        addPoints(0, target, seriesTarget);

        for (double i = Tay ; i < time; i=i+Dis) {

            System.err.printf("%3.2f\t%3.2f\t%3.2f\t%3.2f\n", target, actual, output, (target-actual));
            output = miniPID.getOutput(actual, target, K0, object);
            actual = actual + output;

            addPoints(i, actual, seriesActual);
            addPoints(i, target, seriesTarget);
            IntegralKr += (target-actual);
        }

        TargetActual = actual-target;
        lineChart.getData().add(seriesActual);
        lineChart.getData().add(seriesTarget);


        return lineChart;

    }
    public static LineChart<Number, Number> DispersionGrowthSignalGenerator(){
        NumberAxis xAxis = new NumberAxis(0, 100, 10);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Dispersion Growth Signal");

        // Generate the signal data
        XYChart.Series series = new XYChart.Series();
        series.setName("Signal");
        for (int i = 0; i < 100; i++) {
            double time = i;
            double mean = 0; // initial mean value
            double stdDev = 5; // standard deviation
            double shift = 50; // shift in mean value

            // introduce a shift in the mean value at time 50
            if (i >= 50) {
                shift = 60; // shift the mean value by 10 units
            }

            double amplitude = mean + shift + getRandomNoise(-stdDev, stdDev);
            series.getData().add(new XYChart.Data(time, amplitude));


        }

        // Add the series to the chart
        lineChart.getData().add(series);
        return lineChart;
    }
    private static double getRandomNoise(double min, double max) {
        return min + (Math.random() * (max - min));
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
        MiniPID miniPID = new MiniPID(P, I/10, D);
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
