package GUI;

import UserGestion.mail;
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
    }//set the main app
    public void setDialogStage(Stage dialogstage)
    {
        this.dialogstage=dialogstage;
    }//get the window
    public void init(int nbticket,String sceance,int price,String moviename,String hour )
    {
        this.nbticket=nbticket;
        this.sceance=sceance;
        this.price=price;
        this.moviename=moviename;
        this.hour=hour;
        mailadress.setText(this.mainControleur.user.getMail());//print the mail address of the user
    }

    public void yesclique() {///if user want to receive the mail
        boolean canSend= !mailadress.getText().replace(" ", "").equals("");//if there is a mail in the text box
        if(canSend)
        {
            if(this.mainControleur.user.getName().equals(""))
            {
                this.mainControleur.user.setMail(mailadress.getText());
            }
            mail m=new mail();
            m.sendReceipt(mailadress.getText(), this.mainControleur.user,nbticket,price,moviename,sceance,hour);//send the mail
            dialogstage.close();
        }

    }

    public void noclique() {
        dialogstage.close();//close the window
    }
}
