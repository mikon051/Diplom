package com.example.diplom1;

    public class ObjectPID {
        private double kp; // коэффициент пропорциональности
        private double ki; // коэффициент интегрирования
        private double kd; // коэффициент дифференцирования
        private double prevError; // предыдущая ошибка
        private double integral; // интегральная часть
        private double derivative; // производная часть
        private double setpoint; // заданная точка
        private double output; // выходной сигнал

        private ProcessObject processObject; // объект процесса

        public double getOutputNew() {
            return output;
        }

        public ObjectPID(double kp, double ki, double kd, ProcessObject processObject) {
            this.kp = kp;
            this.ki = ki;
            this.kd = kd;
            this.processObject = processObject;
            prevError = 0;
            integral = 0;
            derivative = 0;
        }

        public ObjectPID(double kp, double ki, double kd) {
            this.kp = kp;
            this.ki = ki;
            this.kd = kd;
            processObject = processObject;
            prevError = 0;
            integral = 0;
            derivative = 0;
        }



        public void setSetpoint(double setpoint) {
            this.setpoint = setpoint;
        }

        public double calculateOutput() {
            double processVariable = processObject.getProcessValue(); // получаем текущее значение процесса
            double error = setpoint - processVariable; // ошибка
            integral += error; // интегральная часть
            derivative = error - prevError; // производная часть
            prevError = error; // обновляем предыдущую ошибку

            output = kp * error + ki * integral + kd * derivative; // расчет выходного сигнала
            return output;
        }

        public void control() {
            double output = calculateOutput();
            processObject.applyOutput(output); // применяем выходной сигнал к объекту процесса
        }
    }

