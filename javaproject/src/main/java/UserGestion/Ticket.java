package UserGestion;

import HelloCiner.filmshow;

public class Ticket {
    private HelloCiner.filmshow filmshow;
    private int price;

    public Ticket (filmshow filmshow,int price)
    {
        this.filmshow=filmshow;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public filmshow getSeance() {
        return this.filmshow;
    }
}
