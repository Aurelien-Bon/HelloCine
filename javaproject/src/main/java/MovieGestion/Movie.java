package MovieGestion;

import javafx.scene.image.Image;

public class Movie {
    private int Id;
    private int CinemaId;
    private String Name;
    private String Overview;
    private String Duration;
    private String movieImageUrl;
    private Image MovieImage;

    public Movie(int id,int CinemaId, String name,String overview,String duration,String movieImageUrl)
    {
        this.CinemaId=CinemaId;
        this.Id=id;
        this.Name=name.replace("'"," ");
        this.Overview = overview.replace("'"," ");
        this.Duration=duration;
        this.movieImageUrl=movieImageUrl;
        if(this.movieImageUrl.equals(""))
        {
            this.MovieImage=null;
        }
        else
        {
            Image image=new Image(movieImageUrl);
            this.MovieImage=image;
        }

    }

    public int getCinemaId() {
        return CinemaId;
    }

    public int getId() {
        return Id;
    }

    public String getDuration() {
        return Duration;
    }

    public String getName() {
        return Name;
    }

    public String getOverview() {
        return Overview;
    }

    public Image getMovieImage() {
        return MovieImage;
    }

    public String getMovieImageUrl() {
        return movieImageUrl;
    }
}
