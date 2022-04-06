package MovieGestion;

import javafx.scene.Node;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private List<Movie> Collection;

    public Collection()
    {
        this.Collection=new ArrayList<>();
    }

    public void addMovie(Movie movie)
    {
        this.Collection.add(movie);
        Mysqlc mysqlc=new Mysqlc();
        mysqlc.MysqlcMovieAdd(movie);
    }
    public void setMovie(Movie movie)
    {
        this.Collection.add(movie);
    }
    public Movie getMovie(String movieName)
    {
        for(var elem:Collection){
            if(elem.getName().equals(movieName))
            {
                return elem;
            }
        }
        return null;
    }
    public void removeMovie(Movie movie)
    {
        Collection.remove(movie);
    }
    public void removeMovieByName(String name)
    {
        for(var elem:Collection)
        {
            if(elem.getName().equals(name))
            {
                Collection.remove(elem);
                Mysqlc mysqlc=new Mysqlc();
                mysqlc.executeQuery("DELETE FROM `movie` WHERE `idtmdb` = "+elem.getId()+";");
            }
        }
    }

    public List<Movie> getMovieList() {
        return Collection;
    }
    public void load(int cinemaId)
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> movieList=mysqlc.MysqlcMovieCollection();
        for(var elem:movieList)
        {
            if(Integer.parseInt(elem.get(0))==cinemaId)
            {
                Movie m=new Movie(Integer.parseInt(elem.get(1)),Integer.parseInt(elem.get(0)), elem.get(2),elem.get(3),elem.get(4),elem.get(5),elem.get(6));
                this.Collection.add(m);
            }

        }
    }
    public Movie getMovieId(int id)
    {
        for(var elem:Collection)
        {
            if(elem.getId()==id)
            {
                return elem;
            }
        }
        return null;
    }
}
