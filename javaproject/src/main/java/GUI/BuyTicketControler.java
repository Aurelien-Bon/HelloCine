package GUI;

import UserGestion.Ticket;
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
    }//set the main apps controller
    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage=dialogStage;
    }//get the actual window
    public void init(List<Ticket> ticketList){
        this.ticketList=ticketList;
        int price=0;
        for(var elem:ticketList)
        {
            price+=elem.getPrice();
        }
        String PriceToPrinte="Total: £"+price;//calculet the price
        totaltopayd.setText(PriceToPrinte);
    }

    public void PayAction() {
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
        if(canpay)//check if case is feed
        {
            for(var elem:ticketList)
            {
                elem.getSeance().removePlace(1);//remove every place buy by user
            }
            this.mainControleur.sendmailConfirme(ticketList.size(),ticketList.get(0).getSeance().getSalleName(),ticketList.get(0).getPrice()*ticketList.size(),ticketList.get(0).getSeance().getMouvie().getName(),ticketList.get(0).getSeance().getDay()+" "+ticketList.get(0).getSeance().getHour());//open the mail ask window
            dialogStage.close();//close this window
        }
        else
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You haven't feel every information");
            alert.showAndWait();//error message to say to the user to feed evrey info
        }
    }

    public void cancelbutton() {
        dialogStage.close();
    }//close this window
}
