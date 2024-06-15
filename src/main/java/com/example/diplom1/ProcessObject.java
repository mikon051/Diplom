package com.example.diplom1;

public interface ProcessObject {
        double getProcessValue(); // получение текущего значения процесса
        void applyOutput(double output); // применение выходного сигнала к объекту процесса
    }
