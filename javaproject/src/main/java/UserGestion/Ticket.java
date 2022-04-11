package UserGestion;

import HelloCiner.filmshow;

public class Ticket {
    private HelloCiner.filmshow filmshow;
    private int price;

    public Ticket (filmshow filmshow,int price)//Contructor ticket
    {
        this.filmshow=filmshow;
        this.price=price;
    }

    public int getPrice() {//getter price
        return price;
    }

    public filmshow getSeance() {
        return this.filmshow;
    }//getter secance tikcet
}
