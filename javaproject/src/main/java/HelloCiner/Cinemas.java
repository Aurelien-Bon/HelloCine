package HelloCiner;

import MovieGestion.Movie;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;

public class Cinemas {
    private List<Cinema> cinemas;

    public Cinemas() {
        this.cinemas = new ArrayList<>();
    }

    public void load()
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> cinemasList=mysqlc.MysqlcCinemaInfo();
        for(var elem:cinemasList)
        {
            Cinema c=new Cinema(Integer.parseInt(elem.get(0)), elem.get(1),elem.get(2));
            c.load();
            this.cinemas.add(c);
        }
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
