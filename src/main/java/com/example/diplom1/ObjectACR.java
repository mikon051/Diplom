package com.example.diplom1;

public class ObjectACR {

    private double K0;
    private double T0;
    private double Tay;

    public ObjectACR(double k0, double t0, double tay) {
        K0 = k0;
        T0 = t0;
        Tay = tay;
    }
    public double getK0() {
        return K0;
    }

    public void setK0(double k0) {
        K0 = k0;
    }

    public double getT0() {
        return T0;
    }

    public void setT0(double t0) {
        T0 = t0;
    }

    public double getTay() {
        return Tay;
    }

    public void setTay(double tay) {
        Tay = tay;
    }


    public double formula() {
      return (this.K0/(this.T0+1))*Math.exp(-(this.Tay));
    }
}
