package GUI;

import HelloCiner.Cinema;
import HelloCiner.MovieRoom;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMovieRoomControler {
    public Label cinename;
    public Label roomname;
    public TextField cineplace;
    private mainControleur  mainControleur;
    private Stage dialogStage;

    public void setMainApp(GUI.mainControleur mainControleur) {
        this.mainControleur = mainControleur;
    }
    public void setDialogStage(Stage dialogStage){this.dialogStage=dialogStage;}
    public void init(String cinename)
    {
        this.cinename.setText(cinename);
        int newnumber=this.mainControleur.Cinemas.getCinemaByName(cinename).getAllMovieRooms().size()+1;
        String roomfullName = cinename +" MovieRoom "+ newnumber;
        this.roomname.setText(roomfullName);
        cineplace.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    cineplace.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void addButon() {
        MovieRoom mr = new MovieRoom(this.roomname.getText(),Integer.parseInt(cineplace.getText()),this.mainControleur.Cinemas.getCinemaByName(cinename.getText()).getCinemaId());
        this.mainControleur.Cinemas.getCinemaByName(cinename.getText()).addMovieRoom(mr);
        dialogStage.close();
    }

    public void cancelButon() {
        dialogStage.close();
    }
}
