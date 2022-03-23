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

    public MovieRoom getMovieRooms(int i) {
        return movieRooms.get(i);
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
}
