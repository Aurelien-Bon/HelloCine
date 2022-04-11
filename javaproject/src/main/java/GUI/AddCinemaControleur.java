package GUI;

import HelloCiner.Cinema;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCinemaControleur {
    public TextField cinename;
    public TextField cineadre;
    private mainControleur  mainControleur;
    private Stage dialogStage;
    private AdminPannelControleur apc;

    public void setMainApp(GUI.mainControleur mainControleur) {
        this.mainControleur = mainControleur;
    }//set the main window
    public void setDialogStage(Stage dialogStage){this.dialogStage=dialogStage;}//set the widow
    public void init(AdminPannelControleur apc)
    {
        this.apc=apc;
    }//initialise the controller of the admin panel

    public void addButon() {//if user clique on the add button
        Cinema c=new Cinema(cinename.getText(),cineadre.getText());
        this.mainControleur.Cinemas.addCinema(c);//add the new cinema
        dialogStage.close();//close the window
        this.apc.setReload();// reload the admin page
    }

    public void cancelButon() {
        dialogStage.close();
    }//if use clique on the cancel button: close window
}
