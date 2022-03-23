package GUI;

import MovieGestion.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class addMovieComfirmControleur {
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
    }
    @FXML
    public void openAddMovieWindow(ActionEvent event) throws IOException
    {
        mainControleur.openAdminPanel();
    }


    public void PressAddBoutton()
    {
        Boolean alreadyadd=false;
        for(var elem:this.mainControleur.Cinemas.getCinemas())
        {
            if(elem.getCinemaId()==this.Movie.getCinemaId()) {
                for (int i = 0; i < elem.getCollection().getMovieList().size(); i++) {
                    if (elem.getCollection().getMovieList().get(i).getId() == this.Movie.getId()) {
                        alreadyadd = true;
                        break;
                    }
                }
            }
        }
        if(!alreadyadd)
        {
            for(var elem:this.mainControleur.Cinemas.getCinemas())
            {
                if(elem.getCinemaId()==this.Movie.getCinemaId())
                {
                       elem.getCollection().addMovie(Movie);
                }
            }
            mainControleur.openAdminPanel();
        }
        else
        {
            System.out.println("ERROR FILM ALREADY ADD");
        }
    }

    public void init(Movie movie)
    {
        Movie=movie;
        movieImage.setImage(this.Movie.getMovieImage());
        titel.setText(this.Movie.getName());
        overview.setText(this.Movie.getOverview());
        duration.setText(this.Movie.getDuration());
    }
}
