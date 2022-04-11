package MovieGestion;

import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;
///list of movie for every
public class Collection {
    private final List<Movie> Collection;

    public Collection()
    {
        this.Collection=new ArrayList<>();
    }//Constuctor

    public void addMovie(Movie movie)//methode for adding a movie inside the collection
    {
        this.Collection.add(movie);
        Mysqlc mysqlc=new Mysqlc();
        mysqlc.MysqlcMovieAdd(movie);//add to the sql database
    }
    public void setMovie(Movie movie)
    {
        this.Collection.add(movie);
    }//methode for adding a movie inside the collection
    public Movie getMovie(String movieName)//methode to get a movie inside the collection with his name
    {
        for(var elem:Collection){
            if(elem.getName().equals(movieName))//if the movie name match
            {
                return elem;//return the movie object
            }
        }
        return null;//if not return null
    }
    public void removeMovieByName(String name)//methode to remove a movie inside the collection with his name
    {
        for(var elem:Collection)
        {
            if(elem.getName().equals(name))//if the movie name match
            {
                Collection.remove(elem);//remove from the list
                Mysqlc mysqlc=new Mysqlc();
                mysqlc.executeQuery("DELETE FROM `movie` WHERE `idtmdb` = "+elem.getId()+";");//remove from the data base
            }
        }
    }

    public List<Movie> getMovieList() {
        return Collection;
    }//getter collection
    public void load(int cinemaId)//loader from the database
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> movieList=mysqlc.MysqlcMovieCollection();//get it from the sql base
        for(var elem:movieList)
        {
            if(Integer.parseInt(elem.get(0))==cinemaId)//if its the good cinema id
            {
                Movie m=new Movie(Integer.parseInt(elem.get(1)),Integer.parseInt(elem.get(0)), elem.get(2),elem.get(3),elem.get(4),elem.get(5),elem.get(6));//create the movie object
                this.Collection.add(m);//add the object to the collection
            }

        }
    }
    public Movie getMovieId(int id)//get a movie in the collection with its id
    {
        for(var elem:Collection)
        {
            if(elem.getId()==id)//if id matchs
            {
                return elem;//return object
            }
        }
        return null;
    }
}
