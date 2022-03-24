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
    public Cinema getCinemaByName(String name)
    {
        for(var elem:cinemas)
        {
            if(elem.getName().equals(name))
            {
                return elem;
            }
        }
        return null;
    }

    public void addCinema(Cinema c) {
        cinemas.add(c);
    }
}
