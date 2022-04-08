package GUI;

import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import mysqlc.Mysqlc;

import java.util.ArrayList;
import java.util.Date;
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
    }
    public void init()
    {

    }

    public void CreateAccoutButton() throws InterruptedException {
        boolean allisfull=true;
        if(mail.getText().replace(" ","").equals(""))
        {
            System.out.println(mail.getText());
            errorMessage.setText("Error there is no mail address");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        if(password.getText().replace(" ","").equals(""))
        {
            System.out.println(password.getText());
            errorMessage.setText("Error there is no password");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        if(fname.getText().replace(" ","").equals(""))
        {
            System.out.println(fname.getText());
            errorMessage.setText("Error there is no first name");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        if(lname.getText().replace(" ","").equals(""))
        {
            System.out.println(lname.getText());
            errorMessage.setText("Error there is no last name");
            errorMessage.setStyle("-fx-border-color: gray; -fx-background-color: red;");
            allisfull=false;
        }
        Mysqlc mysqlc=new Mysqlc();
        List<List<String>> result=mysqlc.MysqlcgetUser();
        for(var elem:result)
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
            List<String> newAccount = new ArrayList<>();
            newAccount.add(mail.getText());
            newAccount.add(password.getText());
            newAccount.add(lname.getText());
            newAccount.add(fname.getText());
            newAccount.add("0/0/0");
            mysqlc.MysqlcAddUser(newAccount);
            TimeUnit.SECONDS.sleep(1);
            this.mainControleur.HelloCine();
        }
    }

    public void cancelButton()
    {
        this.mainControleur.ConnectionPage();
    }
}
