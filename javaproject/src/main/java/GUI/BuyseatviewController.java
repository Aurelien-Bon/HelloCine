package GUI;

import HelloCiner.filmshow;
import UserGestion.Ticket;
import javafx.event.ActionEvent;
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
        this.mainControleur=mainControleur;
    }
    public void init(filmshow filmshow){
        String title="";
        FilmeShow.setText(title);
        this.filmshow=filmshow;
        numbreChose.setText("0");
    }

    public void addticket() {
        List<Ticket> ticketList= new ArrayList<>();
        for(int i=0;i<Integer.parseInt(numbreChose.getText());i++){
            Ticket t=new Ticket(filmshow,filmshow.getPrice());
            ticketList.add(t);
        }
        mainControleur.OpenBuyTicket(ticketList);
        dialogStage.close();
    }

    public void cancel() {
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage=dialogStage;
    }

    public void increment() {
        int value=Integer.parseInt(numbreChose.getText());
        if(value+1<=filmshow.getPlaceTaken())
        {
            value++;
        }
        numbreChose.setText(Integer.toString(value));
    }

    public void decrement() {
        int value=Integer.parseInt(numbreChose.getText());
        if(value-1>=0)
        {
            value--;
        }
        numbreChose.setText(Integer.toString(value));
    }
}
