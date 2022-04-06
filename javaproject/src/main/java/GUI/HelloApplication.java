package GUI;

import UserGestion.mail;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Video;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mysqlc.Mysqlc;


import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {


    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Mysqlc mysqlc= new Mysqlc();
        boolean b = mysqlc.testConnection();
        mainControleur mainControleur=new mainControleur();
        mainControleur.init();
        mainControleur.ConnectionPage();
        this.primaryStage=mainControleur.getStage();
        if(!b)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Test Connection");
            alert.setContentText("ERROR CONNECTION TO DATA BASE");
            this.primaryStage.close();
            alert.showAndWait();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
