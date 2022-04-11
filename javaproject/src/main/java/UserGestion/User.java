package UserGestion;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Ticket> tickets;
    private boolean isAdmin;
    private String name;
    private String Firstname;
    private String mail;
    private String password;

    public User(){///Contructor
    }
    public User(String nam, String Firstnam, String mai, String passwor){///Contructor full
        this.name = nam;
        this.Firstname = Firstnam;
        this.mail = mai;
        this.password = passwor;
        this.tickets=new ArrayList<>();
        this.isAdmin=false;
    }

    public List<Ticket> getTickets(){
        return this.tickets;
    }//getter ticket list

    public String getName() {
        return this.name;
    }//getter name

    public void setName(String name) {
        this.name = name;
    }//setter name

    public String getFirstname() {
        return this.Firstname;
    }//getter first name

    public void setFirstName(String Firstname) {
        this.Firstname = Firstname;
    }//setter first name

    public String getMail() {
        return this.mail;
    }//getter mail

    public void setMail(String mail) {
        this.mail = mail;
    }//setter mail

    public String getPassword() {
        return this.password;
    }//getter password

    public void setPassword(String password) {
        this.name = password;
    } //setter password
    public void setAdmin(boolean b)
    {
        this.isAdmin=b;
    }//setter admin
    public boolean isAdmin()
    {
        return isAdmin;
    }//getter admin
}
