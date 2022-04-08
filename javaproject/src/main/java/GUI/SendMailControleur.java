package GUI;

import UserGestion.mail;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SendMailControleur {
    public TextField mailadress;
    private mainControleur mainControleur;
    private Stage dialogstage;
    private int nbticket;
    private String sceance;
    private int price;
    private String moviename;
    private String hour;

    public void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;
    }
    public void setDialogStage(Stage dialogstage)
    {
        this.dialogstage=dialogstage;
    }
    public void init(int nbticket,String sceance,int price,String moviename,String hour )
    {
        this.nbticket=nbticket;
        this.sceance=sceance;
        this.price=price;
        this.moviename=moviename;
        this.hour=hour;
        mailadress.setText(this.mainControleur.user.getMail());
    }

    public void yesclique() {
        boolean canSend=false;
        if(!mailadress.getText().replace(" ", "").equals(""))
        {
            canSend=true;
        }
        if(canSend)
        {
            if(this.mainControleur.user.getName().equals(""))
            {
                this.mainControleur.user.setName(mailadress.getText());
            }
            mail m=new mail();
            m.sendReceipt(mailadress.getText(), this.mainControleur.user,nbticket,price,moviename,sceance,hour);
            dialogstage.close();
        }

    }

    public void noclique() {
        dialogstage.close();
    }
}
