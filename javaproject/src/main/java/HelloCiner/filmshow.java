package HelloCiner;

import MovieGestion.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.model.MovieDb;
import mysqlc.Mysqlc;

public class filmshow {
    private String Day;
    private String hour;
    private Movie movie;
    private String salleName;
    private int placeTaken;
    private int price;
    private int salleId;
    public filmshow(String day,String hour,Movie mouvie,int placeTaken ,String salleName,int salleId,int price)
    {
        this.Day=day;
        this.hour=hour;
        this.movie=mouvie;
        this.placeTaken=placeTaken;
        this.salleName=salleName;
        this.salleId=salleId;
        this.price=price;
    }

    public filmshow(String day,String hour,String SalleName,int salleId)
    {
        this.salleName=SalleName;
        this.Day=day;
        this.hour=hour;
        this.salleId=salleId;
    }

    public void setMouvie(Movie m) {
        movie = m;
    }
    public Movie getMouvie() {
        return movie;
    }

    public String getSalleName() {
        return salleName;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSalleId(int salleId) {
        this.salleId = salleId;
    }

    public void setNbPlace(int capacity) {
        this.placeTaken=capacity;
    }

    public void removePlace(double value) {
        this.placeTaken-=value;
        Mysqlc mysqlc = new Mysqlc();
        mysqlc.executeQuery("UPDATE `filmshow` SET `placeTaken` = '"+this.placeTaken+"' WHERE `filmshow`.`SalleId` = "+ this.salleId+" AND `filmshow`.`Day` = '"+this.Day+"' AND `filmshow`.`Hours` = '"+this.hour+"';");
    }
}
