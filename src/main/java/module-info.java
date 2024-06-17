module com.example.diplom1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jdk.compiler;
    requires nd4j.api;
    requires deeplearning4j.nn;
    requires commons.math3;
    requires java.desktop;

    opens com.example.diplom1 to javafx.fxml;
    exports com.example.diplom1;
}