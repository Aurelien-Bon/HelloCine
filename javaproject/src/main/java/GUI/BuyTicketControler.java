package GUI;

import HelloCiner.filmshow;
import UserGestion.Ticket;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.List;

public class BuyTicketControler {
    public TextField cardID;
    public TextField cardnumber;
    public TextField cardexp;
    public TextField cardsecu;
    public Label totaltopayd;
    private mainControleur mainControleur;
    private Stage dialogStage;
    private List<Ticket> ticketList;

    public void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;
    }
    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage=dialogStage;
    }
    public void init(List<Ticket> ticketList){
        this.ticketList=ticketList;
        int price=0;
        for(var elem:ticketList)
        {
            price+=elem.getPrice();
        }
        String PriceToPrinte="Total: £"+price;
        totaltopayd.setText(PriceToPrinte);
    }

    public void PayAction(ActionEvent event) {
        boolean canpay = true;
        if(cardnumber.getText().replace(" ", "").equals(""))
        {
            canpay=false;
        }
        if(cardexp.getText().replace(" ", "").equals(""))
        {
            canpay=false;
        }
        if(cardsecu.getText().replace(" ", "").equals(""))
        {
            canpay=false;
        }
        if(cardID.getText().replace(" ", "").equals(""))
        {
            canpay=false;
        }
        if(canpay)
        {
            for(var elem:ticketList)
            {
                elem.getSeance().removePlace(1);
            }
            dialogStage.close();
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You haven't feel every information");
            alert.showAndWait();
        }
    }

    public void cancelbutton(ActionEvent event) {
        dialogStage.close();
    }
}
