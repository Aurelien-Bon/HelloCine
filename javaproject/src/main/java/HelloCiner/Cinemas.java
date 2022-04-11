package HelloCiner;

import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;

public class Cinemas {
    private final List<Cinema> cinemas;

    public Cinemas() {
        this.cinemas = new ArrayList<>();
    }//constructor

    public void load()//methode to load all the cinemas from the database
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> cinemasList=mysqlc.MysqlcCinemaInfo();//getall the data from the database
        for(var elem:cinemasList)
        {
            Cinema c=new Cinema(Integer.parseInt(elem.get(0)), elem.get(1),elem.get(2));//create a new cinema
            c.load();//load it
            this.cinemas.add(c);//add it to the list
        }
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }//getter cinemas
    public Cinema getCinemaByName(String name)//get a specific cinema with the name
    {
        for(var elem:cinemas)
        {
            if(elem.getName().equals(name))//if the name match
            {
                return elem;//return it
            }
        }
        return null;
    }

    public void addCinema(Cinema c) {//add a cinema to the list
        cinemas.add(c);
    }
}
