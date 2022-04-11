package HelloCiner;

import MovieGestion.Movie;
import mysqlc.Mysqlc;

public class filmshow {
    private final String Day;
    private final String hour;
    private Movie movie;
    private final String salleName;
    private int placeTaken;
    private int price;
    private int salleId;
    public filmshow(String day,String hour,Movie mouvie,int placeTaken ,String salleName,int salleId,int price)//Constructor
    {
        this.Day=day;
        this.hour=hour;
        this.movie=mouvie;
        this.placeTaken=placeTaken;
        this.salleName=salleName;
        this.salleId=salleId;
        this.price=price;
    }

    public filmshow(String day,String hour,String SalleName,int salleId)//Contructor
    {
        this.salleName=SalleName;
        this.Day=day;
        this.hour=hour;
        this.salleId=salleId;
    }

    public void setMouvie(Movie m) {
        movie = m;
    }//setter movie
    public Movie getMouvie() {
        return movie;
    }//getter movie

    public String getSalleName() {
        return salleName;
    }//getter salle name

    public String getDay() {
        return Day;
    }//getter day

    public String getHour() {//getter hour
        return hour;
    }

    public int getPlaceTaken() {
        return placeTaken;
    }//getter place use

    public int getSalleId() {
        return salleId;
    }//getter salle id

    public int getPrice() {
        return price;
    }//getter price

    public void setPrice(int price) {
        this.price = price;
    }//setter price

    public void setSalleId(int salleId) {
        this.salleId = salleId;
    }//setter salle id

    public void setNbPlace(int capacity) {
        this.placeTaken=capacity;
    }//setter capacity

    public void removePlace(double value) {//methode for removing a n place in the sceance
        this.placeTaken-=value;//update on object
        Mysqlc mysqlc = new Mysqlc();
        mysqlc.executeQuery("UPDATE `filmshow` SET `placeTaken` = '"+this.placeTaken+"' WHERE `filmshow`.`SalleId` = "+ this.salleId+" AND `filmshow`.`Day` = '"+this.Day+"' AND `filmshow`.`Hours` = '"+this.hour+"';");//update on sql
    }
}
