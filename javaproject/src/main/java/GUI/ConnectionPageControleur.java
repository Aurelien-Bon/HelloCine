package GUI;

import UserGestion.User;
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
        if(mail.getText().replace(" ","").equals(""))
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
            boolean cansend=false;
            String password="";
            for(var elem:result)
            {
                if(elem.get(1).equals(mail.getText()))
                {
                    password=elem.get(2);
                    cansend=true;
                }
            }
            if(cansend)
            {
                m.sendPassword(mail.getText(), password);
                errorMessage.setText("Password send, check your mail!");
                errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: green;");
            }
            else {
                errorMessage.setText("Errore there is no accont with this mail adress");
                errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
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
            User u = new User();
            for(var elem:result)
            {
                if(elem.get(1).equals(this.mail.getText())&&elem.get(2).equals(this.password.getText()))
                {
                    canConnect=true;
                    u.setMail(elem.get(1));
                    u.setPassword(elem.get(2));
                    u.setFirstName(elem.get(4));
                    u.setName(elem.get(3));
                    if(elem.get(5).equals("1"))
                    {
                        u.setAdmin(true);
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
                this.mainControleur.setUset(u);
                mainControleur.HelloCine();
            }
        }
    }

    public void CreateAccountButton() {
        this.mainControleur.CreateAccountPage();
    }

    public void connectasguestButton() {
        User u=new User("","","","");
        this.mainControleur.setUset(u);
        this.mainControleur.HelloCine();
    }
}
