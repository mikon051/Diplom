package com.example.diplom1;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class LaplacianCalculator {
    public static double calculateLaplacian(double x, double y, double z) {
        // Вычисление производных по x, y, z
        double dx = derivative(x, 0.01);
        double dy = derivative(y, 0.01);
        double dz = derivative(z, 0.01);

        // Вычисление вторых производных
        double dxx = derivative(dx, 0.01);
        double dyy = derivative(dy, 0.01);
        double dzz = derivative(dz, 0.01);

        // Вычисление оператора Лапласа
        double laplacian = dxx + dyy + dzz;

        return laplacian;
    }

    private static double derivative(double x, double h) {
        // Численное вычисление производной
        return (f(x + h) - f(x - h)) / (2 * h);
    }

    private static double f(double x) {
        // Реализация функции f(x)
        return x * x;
    }
}