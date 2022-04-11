package GUI;

import UserGestion.User;
import UserGestion.mail;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mysqlc.Mysqlc;

import java.util.List;

public class ConnectionPageControleur {
    public PasswordField password;
    public TextField mail;
    public Label errorMessage;
    private mainControleur mainControleur;

    public  void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;
    }//set the main app
    public void init()
    {

    }

    public void sendPassword()//if user want to have his password by mail
    {
        if(mail.getText().replace(" ","").equals(""))//check if the mail is give
        {
            errorMessage.setText("Error there is no mail adress");//if not print the message in red
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
        }
        else
        {
            mail m=new mail();
            Mysqlc  mysqlc = new Mysqlc();
            List<List<String>> result=mysqlc.MysqlcgetUser();//get all the user
            errorMessage.setText("");
            errorMessage.setStyle("-fx-border-color: null; -fx-background-color: null;");
            boolean cansend=false;
            String password="";
            for(var elem:result)
            {
                if(elem.get(1).equals(mail.getText()))//if the mail is associate with an account
                {
                    password=elem.get(2);
                    cansend=true;
                }
            }
            if(cansend)
            {
                m.sendPassword(mail.getText(), password);//send the mail to the user
                errorMessage.setText("Password send, check your mail!");//print succeed message
                errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: green;");
            }
            else {
                errorMessage.setText("Error there is no account with this mail address");//printe the error message
                errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            }
        }
    }

    public void connectButton() {//if user want to connect
        if(mail.getText().replace(" ","").equals("")|| password.getText().replace(" ","").equals(""))//check if mail and password is give
        {
            errorMessage.setText("Error there is no mail address or password");//print the error
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
        }
        else
        {
            errorMessage.setText("");
            errorMessage.setStyle("-fx-border-color: null; -fx-background-color: null;");
            Mysqlc  mysqlc = new Mysqlc();
            List<List<String>> result=mysqlc.MysqlcgetUser();//get all the user
            boolean canConnect=false;
            User u = new User();
            for(var elem:result)
            {
                if(elem.get(1).equals(this.mail.getText())&&elem.get(2).equals(this.password.getText()))//if mail and password match
                {
                    canConnect=true;//create the user
                    u.setMail(elem.get(1));
                    u.setPassword(elem.get(2));
                    u.setFirstName(elem.get(4));
                    u.setName(elem.get(3));
                    if(elem.get(5).equals("1"))//if the user is admin
                    {
                        u.setAdmin(true);
                    }
                }
            }
            if(!canConnect)
            {
                errorMessage.setText("Wrong password or email address!");//print the error
                errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            }
            else
            {
                this.mainControleur.setUset(u);//set the user of the app
                mainControleur.HelloCine();//open the main page
            }
        }
    }

    public void CreateAccountButton() {
        this.mainControleur.CreateAccountPage();
    }//open the create account page

    public void connectasguestButton() {//if user want to connect as a guest
        User u=new User("","","","");
        this.mainControleur.setUset(u);//set the user of the app
        this.mainControleur.HelloCine();//open the main page
    }
}
