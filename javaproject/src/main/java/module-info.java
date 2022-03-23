module com.example.javaproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires themoviedbapi;
    requires java.sql;

    opens GUI to javafx.fxml;
    exports GUI;
}