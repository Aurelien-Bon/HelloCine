package HelloCiner;

import MovieGestion.Collection;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;

public class MovieRoom {
    private final String Name;
    private final int capacity;
    private final List<filmshow> movieshow;
    private final int SalleId;

    public MovieRoom(String Name,int capacity,int cinemaId)//Constuctor
    {
        this.Name=Name;
        this.capacity=capacity;
        Mysqlc mysqlc=new Mysqlc();
        this.SalleId=mysqlc.MysqlcaddMovieRoom(Name,capacity,cinemaId);
        movieshow=new ArrayList<>();
    }

    public MovieRoom(int SalleID,String Name,int capacity)//Constructor
    {
        this.SalleId=SalleID;
        this.Name=Name;
        this.capacity=capacity;
        movieshow=new ArrayList<>();
    }

    public void addMovieShow(filmshow movie) {//add a movieshow to the list
        movieshow.removeIf(elem -> movie.getDay().equals(elem.getDay()) && movie.getHour().equals(elem.getHour()));//check if movieshow dose not existe and delet it if yes
        Mysqlc mysqlc=new Mysqlc();
        mysqlc.executeQuery("DELETE FROM `filmshow` WHERE `filmshow`.`Day` = \""+movie.getDay()+"\" AND `filmshow`.`Hours` = \""+movie.getHour()+"\" AND `filmshow`.`SalleId` =\""+movie.getSalleId()+"\";");//delet it in the database
        mysqlc.MysqlcfilmShowAdd(movie);//add the new movie show in the database
        this.movieshow.add(movie);//add it in the object
    }
    public void removeMovieShow(filmshow movie)//remove a filmshow from the list
    {
        movieshow.removeIf(elem -> movie.getDay().equals(elem.getDay()) && movie.getHour().equals(elem.getHour()));//check if movieshow dose not existe and delet it if yes
        Mysqlc mysqlc=new Mysqlc();
        mysqlc.executeQuery("DELETE FROM `filmshow` WHERE `filmshow`.`Day` = \""+movie.getDay()+"\" AND `filmshow`.`Hours` = \""+movie.getHour()+"\" AND `filmshow`.`SalleId` =\""+movie.getSalleId()+"\";");//delet it in the database
    }
    public String getName() {
        return Name;
    }//getter name

    public int getCapacity() {
        return capacity;
    }//getter capacity

    public void load(Collection c)//load the movie room from the database
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> movieShowList=mysqlc.MysqlcfilmShowInfo();//get the data
        for(var elem:movieShowList)
        {
            if(Integer.parseInt(elem.get(0)) == SalleId)//add them to the good movie room
            {
                filmshow fs=new filmshow(elem.get(2),elem.get(3),c.getMovieId(Integer.parseInt(elem.get(1))),Integer.parseInt(elem.get(4)),this.Name,this.SalleId,Integer.parseInt(elem.get(5)));
                movieshow.add(fs);
            }
        }
    }

    public List<filmshow> getAllMovieshow() {
        return movieshow;
    }//getter of all film show
    public filmshow getSpecialMovieShow(String day,int h)//getter of a special movie show with day and hour
    {
        String hours = switch (h) {//get the hour
            case 0 -> "10h";
            case 1 -> "13h";
            case 2 -> "16h";
            case 3 -> "19h";
            case 4 -> "22h";
            default -> "null";
        };
        for(var elem:movieshow)
        {
            if(elem.getHour().equals(hours)&&elem.getDay().equals(day))//if they are the same
            {
                return elem;//return the good movie show
            }
        }
        return null;
    }

    public int getId() {
        return SalleId;
    }//getter salle id
}
