package GUI;

import MovieGestion.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;

import java.io.IOException;


public class addMovieComfirmControleur {
    public AnchorPane fond;
    public MediaView trailer;
    public WebView webView;
    private mainControleur mainControleur;
    @FXML
    public ImageView movieImage;
    public Label titel;
    public Label overview;
    public Label duration;
    Movie Movie;

    public void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;
    }//get the main app
    @FXML
    public void openAddMovieWindow() throws IOException
    {
        mainControleur.openAdminPanel();
    }


    public void PressAddBoutton()//if the user add the movie
    {
        boolean alreadyadd=false;
        for(var elem:this.mainControleur.Cinemas.getCinemas())
        {
            if(elem.getCinemaId()==this.Movie.getCinemaId()) {
                for (int i = 0; i < elem.getCollection().getMovieList().size(); i++) {
                    if (elem.getCollection().getMovieList().get(i).getId() == this.Movie.getId()) {//add the movie to the good collection of the cinema
                        alreadyadd = true;
                        break;
                    }
                }
            }
        }
        if(!alreadyadd)//check if the movie was not already in the list
        {
            for(var elem:this.mainControleur.Cinemas.getCinemas())//add it
            {
                if(elem.getCinemaId()==this.Movie.getCinemaId())
                {
                       elem.getCollection().addMovie(Movie);
                }
            }
            webView.getEngine().load("www.google.com");
            mainControleur.openAdminPanel();

        }
        else
        {
            Alert a = new Alert(Alert.AlertType.ERROR);//print error
            a.setTitle("Error film already add");
            a.setContentText("Error film already add");
            a.showAndWait();
        }
    }

    public void init(Movie movie)//get the movie to use
    {
        Movie=movie;
        movieImage.setImage(this.Movie.getMovieImage());
        titel.setText(this.Movie.getName());
        overview.setText(this.Movie.getOverview());
        duration.setText(this.Movie.getDuration());
        webView.getEngine().load(this.Movie.getTraileurLink());
    }
}
