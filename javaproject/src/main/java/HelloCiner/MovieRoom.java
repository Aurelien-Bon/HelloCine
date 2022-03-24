package HelloCiner;

import MovieGestion.Collection;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;

public class MovieRoom {
    private String Name;
    private int capacity;
    private List<filmshow> movieshow;
    private int SalleId;

    public MovieRoom(String Name,int capacity,int cinemaId)
    {
        this.Name=Name;
        this.capacity=capacity;
        Mysqlc mysqlc=new Mysqlc();
        this.SalleId=mysqlc.MysqlcaddMovieRoom(Name,capacity,cinemaId);
        movieshow=new ArrayList<>();
    }

    public MovieRoom(int SalleID,String Name,int capacity)
    {
        this.SalleId=SalleID;
        this.Name=Name;
        this.capacity=capacity;
        movieshow=new ArrayList<>();
    }

    public void addMovieShow(filmshow movie) {
        movieshow.removeIf(elem -> movie.getDay().equals(elem.getDay()) && movie.getHour().equals(elem.getHour()));
        Mysqlc mysqlc=new Mysqlc();
        mysqlc.executeQuery("DELETE FROM `filmshow` WHERE `filmshow`.`Day` = \""+movie.getDay()+"\" AND `filmshow`.`Hours` = \""+movie.getHour()+"\" AND `filmshow`.`SalleId` =\""+movie.getSalleId()+"\";");
        mysqlc.MysqlcfilmShowAdd(movie);
        this.movieshow.add(movie);
    }
    public void removeMovieShow(filmshow movie)
    {
        movieshow.removeIf(elem -> movie.getDay().equals(elem.getDay()) && movie.getHour().equals(elem.getHour()));
        Mysqlc mysqlc=new Mysqlc();
        mysqlc.executeQuery("DELETE FROM `filmshow` WHERE `filmshow`.`Day` = \""+movie.getDay()+"\" AND `filmshow`.`Hours` = \""+movie.getHour()+"\" AND `filmshow`.`SalleId` =\""+movie.getSalleId()+"\";");
    }
    public String getName() {
        return Name;
    }

    public filmshow getMovieShow(int i) {
        return movieshow.get(i);
    }

    public int getCapacity() {
        return capacity;
    }

    public void load(Collection c)
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> movieShowList=mysqlc.MysqlcfilmShowInfo();
        for(var elem:movieShowList)
        {
            if(Integer.parseInt(elem.get(0)) == SalleId)
            {
                filmshow fs=new filmshow(elem.get(2),elem.get(3),c.getMovieId(Integer.parseInt(elem.get(1))),Integer.parseInt(elem.get(4)),this.Name,this.SalleId,Integer.parseInt(elem.get(5)));
                movieshow.add(fs);
            }
        }
    }

    public List<filmshow> getAllMovieshow() {
        return movieshow;
    }
    public filmshow getSpecialMovieShow(String day,int h)
    {
        String hours;
        switch (h)
        {
            case 0:
                hours="10h";
                break;
            case 1:
                hours="13h";
                break;
            case 2:
                hours="16h";
                break;
            case 3:
                hours="19h";
                break;
            case 4:
                hours="22h";
                break;
            default:
                hours="null";
        }
        for(var elem:movieshow)
        {
            if(elem.getHour().equals(hours)&&elem.getDay().equals(day))
            {
                return elem;
            }
        }
        return null;
    }

    public int getId() {
        return SalleId;
    }
}
