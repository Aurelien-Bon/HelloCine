module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires themoviedbapi;
    requires java.sql;
    requires java.mail;
    requires javafx.media;
    requires javafx.web;

    opens GUI to javafx.fxml;
    exports GUI;
}