package GUI;

import UserGestion.mail;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.Video;
import javafx.application.Application;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;

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
        //mail mail=new mail();
        //mail.sendPassword("nathan.orsinet02@gmail.com","Nathan Gros bg");
        launch();
    }
}
