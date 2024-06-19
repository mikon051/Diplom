package com.example.diplom1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class


TextData {
    private StringProperty text1;
    private StringProperty text2;
    private StringProperty text3;

    public TextData(String text1, String text2, String text3) {
        this.text1 = new SimpleStringProperty(text1);
        this.text2 = new SimpleStringProperty(text2);
        this.text3 = new SimpleStringProperty(text3);
    }

    public String getText1() {
        return text1.get();
    }

    public void setText1(String text1) {
        this.text1.set(text1);
    }

    public StringProperty text1Property() {
        return text1;
    }

    public String getText2() {
        return text2.get();
    }

    public void setText2(String text2) {
        this.text2.set(text2);
    }

    public StringProperty text2Property() {
        return text2;
    }

    public String getText3() {
        return text3.get();
    }

    public void setText3(String text3) {
        this.text3.set(text3);
    }

    public StringProperty text3Property() {
        return text3;
    }
}

