package com.example.diplom1;


public class NewPID {
    private  double f;
    private double kp; // коэффициент пропорциональности
    private double ki; // коэффициент интегрирования
    private double kd; // коэффициент дифференцирования
    private double prevError; // предыдущая ошибка
    private double integral; // интегральная часть
    private double derivative; // производная часть
    private double setpoint; // заданная точка
    private double output; // выходной сигнал

    public NewPID(double kp, double ki, double kd, double f) {
        this.kp = kp;
        this.ki = ki;
        this.kd = kd;
        this.f = f;
        prevError = 0;
        integral = 0;
        derivative = 0;
    }

    public void setSetpoint(double setpoint) {
        this.setpoint = setpoint;
    }

    public double calculateOutput(double processVariable) {
        double error = setpoint - processVariable; // ошибка
        integral += error; // интегральная часть
        derivative = error - prevError; // производная часть
        prevError = error; // обновляем предыдущую ошибку

        output = kp * error + ki * integral + kd * derivative; // расчет выходного сигнала
        return output;
    }
}

