package GUI;

import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {


    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainControleur mainControleur=new mainControleur();
        mainControleur.init();
        mainControleur.HelloCine();
        this.primaryStage=mainControleur.getStage();
    }


    public static void main(String[] args) {
        launch();
    }
}
