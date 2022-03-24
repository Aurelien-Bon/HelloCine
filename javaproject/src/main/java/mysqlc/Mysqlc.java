package mysqlc;
import HelloCiner.Cinema;
import HelloCiner.filmshow;
import MovieGestion.Movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Mysqlc {
    private String url = "jdbc:mysql://localhost:3306/hellocine";
    private String user = "root";
    private String password = "";
    private Statement stmt;



    public List<List<String>> MysqlcCinemaInfo()
    {
        // TODO code application logic here
        Connection conn = null;
        ResultSet rs=null;
        List<List<String>> result=new ArrayList<>();
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `cinema` WHERE 1");
            while (rs.next())
            {
                List<String> a = new ArrayList<>();
                a.add(Integer.toString(rs.getInt(1)));
                a.add(rs.getString(2));
                a.add(rs.getString(3));
                result.add(a);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public int MysqlcCinemaAdd(String name,String adress)
    {
        int id=0;
        // TODO code application logic here
        Connection conn = null;
        ResultSet rs=null;

        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `cinema` (`id`, `Name`, `Adress`) VALUES (NULL, '"+name+"', '"+adress+"');");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id FROM `cinema` WHERE `Name`=\""+name+"\" AND `Adress` = \""+adress+"\";");
            while(rs.next())
            {
                id = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id;
    }


    public List<List<String>> MysqlcfilmShowInfo()
    {
        // TODO code application logic here
        Connection conn = null;
        ResultSet rs=null;
        List<List<String>> result=new ArrayList<>();
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `filmshow` WHERE 1");
            while (rs.next())
            {
                List<String> a= new ArrayList<>();
                a.add(Integer.toString(rs.getInt(2)));
                a.add(Integer.toString(rs.getInt(3)));
                a.add(rs.getString(4));
                a.add(rs.getString(5));
                a.add(Integer.toString(rs.getInt(6)));
                a.add(Integer.toString(rs.getInt(7)));
                result.add(a);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public void MysqlcfilmShowAdd(filmshow filmshow)
    {
        // TODO code application logic here
        Connection conn = null;

        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `filmshow` (`id`, `SalleID`, `MovieID`, `Day`, `Hours`, `placeTaken`,`price`) VALUES (NULL, '"+filmshow.getSalleId()+"', '"+filmshow.getMouvie().getId()+"', '"+filmshow.getDay()+"', '"+filmshow.getHour()+"', '"+filmshow.getPlaceTaken()+"', '"+filmshow.getPrice()+"');");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    public List<List<String>> MysqlcMovieCollection()
    {
        // TODO code application logic here
        Connection conn = null;
        ResultSet rs=null;
        List<List<String>> result=new ArrayList<>();
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `movie` WHERE 1");
            while(rs.next())
            {
                List<String> a= new ArrayList<>();
                a.add(Integer.toString(rs.getInt(2)));
                a.add(Integer.toString(rs.getInt(3)));
                a.add(rs.getString(4));
                a.add(rs.getString(5));
                a.add(rs.getString(6));
                a.add(rs.getString(7));
                result.add(a);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }


    public void MysqlcMovieAdd(Movie movie)
    {
        // TODO code application logic here
        Connection conn = null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `movie` (`id`,`cinemaID`,`idtmdb`, `Title`, `Overview`, `Duration`, `MovieImageURl`) VALUES (NULL,'"+movie.getCinemaId()+"', '"+movie.getId()+"', '"+movie.getName()+"', '"+movie.getOverview()+"', '"+movie.getDuration()+"', '"+movie.getMovieImageUrl()+"');");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<List<String>> MysqlcMovieRoomList()
    {
        // TODO code application logic here
        Connection conn = null;
        ResultSet rs=null;
        List<List<String>> result=new ArrayList<>();
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `movieroom` WHERE 1");
            while(rs.next())
            {
                List<String> a= new ArrayList<>();
                a.add(Integer.toString(rs.getInt(1)));
                a.add(Integer.toString(rs.getInt(4)));
                a.add(rs.getString(2));
                a.add(Integer.toString(rs.getInt(3)));
                result.add(a);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    public int MysqlcaddMovieRoom(String name,int nbplace,int idCinema)
    {
        int id=0;
        // TODO code application logic here
        Connection conn = null;
        ResultSet rs=null;

        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO `movieroom` (`id`, `Name`, `numbrePlace`, `idCinema`) VALUES (NULL, '"+name+"', '"+nbplace+"', '"+idCinema+"');");
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT id FROM `movieroom` WHERE `Name`=\""+name+"\" AND `idCinema`=\""+idCinema+"\";");
            while(rs.next())
            {
                id = rs.getInt(1);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return id;
    }


    public void executeQuery(String query)
    {
        Connection conn = null;
        ResultSet rs=null;
        try {
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
