package MovieGestion;

import javafx.scene.image.Image;

public class Movie {
    private final int Id;
    private final int CinemaId;
    private final String Name;
    private final String Overview;
    private final String Duration;
    private final String movieImageUrl;
    private final Image MovieImage;
    private final String traileurUrl;

    public Movie(int id,int CinemaId, String name,String overview,String duration,String movieImageUrl,String traileurUrl)//Constructor
    {
        this.traileurUrl=traileurUrl;
        this.CinemaId=CinemaId;
        this.Id=id;
        this.Name=name.replace("'"," ");
        this.Overview = overview.replace("'"," ");
        this.Duration=duration;
        this.movieImageUrl=movieImageUrl;
        if(this.movieImageUrl.equals(""))//get the movie image if it's existe
        {
            this.MovieImage=null;
        }
        else
        {
            this.MovieImage = new Image(movieImageUrl);
        }

    }

    public int getCinemaId() {
        return CinemaId;
    }//getter cinemaid

    public int getId() {
        return Id;
    }//getter id

    public String getDuration() {
        return Duration;
    }//getter duration

    public String getName() {
        return Name;
    }//getter name

    public String getOverview() {
        return Overview;
    }//getter overview

    public Image getMovieImage() {
        return MovieImage;
    }//getter Movie image

    public String getMovieImageUrl() {
        return movieImageUrl;
    }//getter image url

    public String getTraileurLink() {
        return this.traileurUrl;
    }//getter trailer url
}
