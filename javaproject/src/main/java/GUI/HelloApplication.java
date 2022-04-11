package GUI;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import mysqlc.Mysqlc;

public class HelloApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Mysqlc mysqlc= new Mysqlc();
        boolean b = mysqlc.testConnection();//try the sql connection
        mainControleur mainControleur=new mainControleur();
        mainControleur.init();//start the apps
        mainControleur.ConnectionPage();//set the window on te connection page
        //main window
        Stage primaryStage1 = mainControleur.getStage();//set on the main windows
        if(!b)//if no database connection
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Test Connection");
            alert.setContentText("ERROR CONNECTION TO DATA BASE");
            primaryStage1.close();//close the apps
            alert.showAndWait();//open a error message
        }
    }

    public static void main(String[] args) {
        launch();
    }///lauche the apps
}
