package HelloCiner;

import MovieGestion.Collection;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final int cinemaId;
    private final String name;
    private final List<MovieRoom>movieRooms;
    private final String adress;
    public Collection Collection;
    public Cinema(String name,String adress)//Constructor with no id
    {
        this.name=name;
        this.adress=adress;
        this.movieRooms=new ArrayList<>();
        this.Collection=new Collection();
        Mysqlc mysqlc=new Mysqlc();
        this.cinemaId= mysqlc.MysqlcCinemaAdd(name,adress);//get the movie id via the database
    }
    public Cinema(int cinemaId, String name,String adress)//Constructor whith id
    {
        this.cinemaId=cinemaId;
        this.name=name;
        this.adress=adress;
        this.Collection=new Collection();
        this.Collection.load(cinemaId);
        movieRooms=new ArrayList<>();
    }
    public String getName() {
        return name;
    }//getter name

    public MovieRoom getMovieRooms(String name) {//getter movie with a name
        for(var elem:movieRooms)
        {
            if(elem.getName().equals(name))//if the name are the same
            {
                return elem;//return the movie object
            }
        }
        return null;
    }

    public String getAdress() {
        return adress;
    }//getter address

    public int getCinemaId() {
        return cinemaId;
    }//getter id cinema

    public MovieGestion.Collection getCollection() {
        return Collection;
    }//getter collection of the cinema

    public void load()//methode to load the cinema data from the database
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> listMovieRoom=mysqlc.MysqlcMovieRoomList();//get the data from the database
        for(var elem:listMovieRoom)
        {
            if(Integer.parseInt(elem.get(1))==this.cinemaId)//add the movie to the cinema
            {
                MovieRoom mr=new MovieRoom(Integer.parseInt(elem.get(0)),elem.get(2),Integer.parseInt(elem.get(3)));
                mr.load(this.Collection);
                movieRooms.add(mr);
            }
        }
    }

    public List<MovieRoom> getAllMovieRooms() {
        return this.movieRooms;
    }//getter of all movie room of the cinema

    public void addMovieRoom(MovieRoom movieRoom) {//add a movieroom to the cinema
        this.movieRooms.add(movieRoom);
    }
}
