package GUI;

import HelloCiner.filmshow;
import UserGestion.Ticket;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BuyseatviewController {
    public Label numbreChose;
    public Slider slider;
    public Label FilmeShow;
    public AnchorPane placeChose;
    private mainControleur mainControleur;
    private filmshow filmshow;
    private Stage dialogStage;

    public void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;//get the main application controller
    }
    public void init(filmshow filmshow){
        this.filmshow=filmshow;
        numbreChose.setText("0");//set the number of ticket
    }

    public void addticket() {///methode use when user clique on the button pay
        List<Ticket> ticketList= new ArrayList<>();
        for(int i=0;i<Integer.parseInt(numbreChose.getText());i++){
            Ticket t=new Ticket(filmshow,filmshow.getPrice());
            ticketList.add(t);
        }
        mainControleur.OpenBuyTicket(ticketList);//open the Buy ticket page
        dialogStage.close();//close the window
    }

    public void cancel() {
        dialogStage.close();
    }//close the window

    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage=dialogStage;
    }//get the window create

    public void increment() {
        int value=Integer.parseInt(numbreChose.getText());//increment the number of ticket to buy
        if(value+1<=filmshow.getPlaceTaken())//check if there is the number is not exede the number avalabel
        {
            value++;
        }
        numbreChose.setText(Integer.toString(value));
    }

    public void decrement() {//decrement the number of ticket to buy
        int value=Integer.parseInt(numbreChose.getText());//check if there is the number is higher than 0
        if(value-1>=0)
        {
            value--;
        }
        numbreChose.setText(Integer.toString(value));
    }
}
