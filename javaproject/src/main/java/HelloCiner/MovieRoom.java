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

    public MovieRoom(int SalleID,String Name,int capacity)
    {
        this.SalleId=SalleID;
        this.Name=Name;
        this.capacity=capacity;
        movieshow=new ArrayList<>();
    }

    public void addMovieShow(filmshow movie) {
        this.movieshow.add(movie);
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
                filmshow fs=new filmshow(elem.get(2),elem.get(3),c.getMovieId(Integer.parseInt(elem.get(1))),Integer.parseInt(elem.get(4)),this.SalleId);
                movieshow.add(fs);
            }
        }
    }

    public List<filmshow> getAllMovieshow() {
        return movieshow;
    }
}
