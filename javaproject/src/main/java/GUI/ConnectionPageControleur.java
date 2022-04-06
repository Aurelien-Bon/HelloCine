package GUI;

import UserGestion.mail;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mysqlc.Mysqlc;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ConnectionPageControleur {
    public PasswordField password;
    public TextField mail;
    public Label errorMessage;
    private mainControleur mainControleur;

    public  void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;
    }
    public void init()
    {

    }

    public void sendPassword()
    {
        if(mail.getText().replace(" ","").equals("")|| password.getText().replace(" ","").equals(""))
        {
            errorMessage.setText("Errore there is no mail adress");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
        }
        else
        {
            mail m=new mail();
            Mysqlc  mysqlc = new Mysqlc();
            List<List<String>> result=mysqlc.MysqlcgetUser();
            errorMessage.setText("");
            errorMessage.setStyle("-fx-border-color: null; -fx-background-color: null;");
            for(var elem:result)
            {
                if(elem.get(1).equals(mail.getText()))
                {
                    //m.sendPassword(elem.get(1), elem.get(2));
                }
            }
        }

    }

    public void connectButton() throws InterruptedException {
        if(mail.getText().replace(" ","").equals("")|| password.getText().replace(" ","").equals(""))
        {
            errorMessage.setText("Errore there is no mail adress or password");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
        }
        else
        {
            errorMessage.setText("");
            errorMessage.setStyle("-fx-border-color: null; -fx-background-color: null;");
            Mysqlc  mysqlc = new Mysqlc();
            List<List<String>> result=mysqlc.MysqlcgetUser();
            boolean canConnect=false;
            boolean isadmin=false;
            for(var elem:result)
            {
                if(elem.get(1).equals(this.mail.getText())&&elem.get(2).equals(this.password.getText()))
                {
                    canConnect=true;
                    if(elem.get(6).equals("1"))
                    {
                        isadmin=true;
                    }
                }
            }
            if(!canConnect)
            {
                errorMessage.setText("Wrong password or email address!");
                errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            }
            else
            {
                mainControleur.HelloCine(isadmin);
            }
        }
    }

    public void CreateAccountButton() {
        this.mainControleur.CreateAccountPage();
    }

    public void connectasguestButton() {
        this.mainControleur.HelloCine(false);
    }
}
