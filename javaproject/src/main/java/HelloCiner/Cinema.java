package HelloCiner;

import MovieGestion.Collection;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int cinemaId;
    private String name;
    private List<MovieRoom>movieRooms;
    private String adress;
    public Collection Collection;
    public Cinema(String name,String adress)
    {
        this.name=name;
        this.adress=adress;
        this.movieRooms=new ArrayList<>();
        this.Collection=new Collection();
        Mysqlc mysqlc=new Mysqlc();
        this.cinemaId= mysqlc.MysqlcCinemaAdd(name,adress);
    }
    public Cinema(int cinemaId, String name,String adress)
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
    }

    public MovieRoom getMovieRooms(String name) {
        for(var elem:movieRooms)
        {
            if(elem.getName().equals(name))
            {
                return elem;
            }
        }
        return null;
    }

    public String getAdress() {
        return adress;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public MovieGestion.Collection getCollection() {
        return Collection;
    }

    public void load()
    {
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> listMovieRoom=mysqlc.MysqlcMovieRoomList();
        for(var elem:listMovieRoom)
        {
            if(Integer.parseInt(elem.get(1))==this.cinemaId)
            {
                MovieRoom mr=new MovieRoom(Integer.parseInt(elem.get(0)),elem.get(2),Integer.parseInt(elem.get(3)));
                mr.load(this.Collection);
                movieRooms.add(mr);
            }
        }
    }

    public List<MovieRoom> getAllMovieRooms() {
        return this.movieRooms;
    }

    public void addMovieRoom(MovieRoom movieRoom) {
        this.movieRooms.add(movieRoom);
    }
}
