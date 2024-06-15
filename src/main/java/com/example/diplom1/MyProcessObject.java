package com.example.diplom1;

public class MyProcessObject implements ProcessObject {
        private double value; // текущее значение процесса

        public MyProcessObject(double initialValue) {
            this.value = initialValue;
        }

        public double getProcessValue() {
            return value;
        }

        public void applyOutput(double output) {
            value += output; // изменяем значение процесса в соответствии с выходным сигналом
        }
}
