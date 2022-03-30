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
    private AdminPannelControleur apc;

    public void setMainApp(GUI.mainControleur mainControleur) {
        this.mainControleur = mainControleur;
    }
    public void setDialogStage(Stage dialogStage){this.dialogStage=dialogStage;}
    public void init(AdminPannelControleur apc)
    {
        this.apc=apc;
    }

    public void addButon() {
        Cinema c=new Cinema(cinename.getText(),cineadre.getText());
        this.mainControleur.Cinemas.addCinema(c);
        dialogStage.close();
        this.apc.setReload();
    }

    public void cancelButon(ActionEvent event) {
        dialogStage.close();
    }
}
