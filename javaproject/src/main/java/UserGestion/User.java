package UserGestion;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Ticket> tickets;
    private boolean isAdmin;
    public User()
    {
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
}
