package HelloCiner;

import MovieGestion.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;

public class filmshow {
    private String Day;
    private String hour;
    private Movie movie;
    private int salleId;
    private int placeTaken;
    public filmshow(String day,String hour,Movie mouvie,int placeTaken ,int salleid)
    {
        this.Day=day;
        this.hour=hour;
        this.movie=mouvie;
        this.placeTaken=placeTaken;
        this.salleId=salleid;
    }

    public void setMouvie(Movie m) {
        movie = m;
    }
    public Movie getMouvie() {
        return movie;
    }

    public String getDay() {
        return Day;
    }

    public String getHour() {
        return hour;
    }

    public int getPlaceTaken() {
        return placeTaken;
    }
    public void addPlace()
    {
        placeTaken++;
    }

    public int getSalleId() {
        return salleId;
    }
}
