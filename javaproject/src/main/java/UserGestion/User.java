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

    public User(){
    }
    public User(String nam, String Firstnam, String mai, String passwor){
        this.name = nam;
        this.Firstname = Firstnam;
        this.mail = mai;
        this.password = passwor;
        this.tickets=new ArrayList<>();
        this.isAdmin=false;
    }

    public void addticket(Ticket t)
    {
        this.tickets.add(t);
    }
    public List<Ticket> getTickets(){
        return this.tickets;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return this.Firstname;
    }

    public void setFirstName(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.name = password;
    }
    public void setAdmin(boolean b)
    {
        this.isAdmin=b;
    }
    public boolean isAdmin()
    {
        return isAdmin;
    }
}
