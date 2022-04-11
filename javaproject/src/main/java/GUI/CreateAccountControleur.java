package GUI;

import UserGestion.User;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateAccountControleur {
    public TextField lname;
    public TextField fname;
    public TextField password;
    public TextField mail;
    public Label errorMessage;
    private mainControleur mainControleur;

    public void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;
    }//set main app
    public void init()
    {

    }

    public void CreateAccoutButton() throws InterruptedException {
        boolean allisfull=true;
        if(mail.getText().replace(" ","").equals(""))//check if text filed is not empty
        {
            System.out.println(mail.getText());
            errorMessage.setText("Error there is no mail address");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        if(password.getText().replace(" ","").equals(""))//check if text filed is not empty
        {
            System.out.println(password.getText());
            errorMessage.setText("Error there is no password");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        if(fname.getText().replace(" ","").equals(""))//check if text filed is not empty
        {
            System.out.println(fname.getText());
            errorMessage.setText("Error there is no first name");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        if(lname.getText().replace(" ","").equals(""))//check if text filed is not empty
        {
            System.out.println(lname.getText());
            errorMessage.setText("Error there is no last name");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> result=mysqlc.MysqlcgetUser();//get all the user
        for(var elem:result)//check if the mail is not already use
        {
            if(elem.get(1).equals(mail.getText()))
            {
                errorMessage.setText("Mail already use!");
                errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
                allisfull=false;
            }
        }
        if(allisfull)
        {
            errorMessage.setText("Account Create");
            errorMessage.setStyle("-fx-border-color: DarkGreen; -fx-background-color: green;");
            List<String> newAccount = new ArrayList<>();//create the new account
            newAccount.add(mail.getText());
            newAccount.add(password.getText());
            newAccount.add(lname.getText());
            newAccount.add(fname.getText());
            mysqlc.MysqlcAddUser(newAccount);//add the account to the database
            User u = new User(lname.getText(),fname.getText(),mail.getText(),password.getText());//create the new account
            this.mainControleur.setUset(u);//set the user
            TimeUnit.SECONDS.sleep(1);
            this.mainControleur.HelloCine();//open the main page
        }
    }

    public void cancelButton()
    {
        this.mainControleur.ConnectionPage();
    }//open the connect page
}
