package GUI;

import HelloCiner.Cinema;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCinemaControleur {
    public TextField cinename;
    public TextField cineadre;
    private mainControleur  mainControleur;
    private Stage dialogStage;

    public void setMainApp(GUI.mainControleur mainControleur) {
        this.mainControleur = mainControleur;
    }
    public void setDialogStage(Stage dialogStage){this.dialogStage=dialogStage;}
    public void init()
    {

    }

    public void addButon() {
        Cinema c=new Cinema(cinename.getText(),cineadre.getText());
        this.mainControleur.Cinemas.addCinema(c);
        dialogStage.close();
    }

    public void cancelButon(ActionEvent event) {
        dialogStage.close();
    }
}
