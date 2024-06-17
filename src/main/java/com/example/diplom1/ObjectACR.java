package com.example.diplom1;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static com.example.diplom1.LaplacianCalculator.calculateLaplacian;

public class ObjectACR {

    private double K0;
    private double T0;
    private double Tay;
    public ObjectACR(double k0, double t0, double tay) {
        K0 = k0;
        T0 = t0;
        Tay = tay;
    }

    double L = calculateLaplacian(K0, T0, Tay );
    public double func() {
        return  (this.K0/((this.T0*L)+1))*Math.exp(-(this.Tay*L));
    }
}
