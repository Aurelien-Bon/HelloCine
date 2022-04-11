package GUI;

import HelloCiner.MovieRoom;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddMovieRoomControler {
    public Label cinename;
    public Label roomname;
    public TextField cineplace;
    private mainControleur  mainControleur;
    private Stage dialogStage;
    private AdminPannelControleur apc;

    public void setMainApp(GUI.mainControleur mainControleur) {
        this.mainControleur = mainControleur;
    }//get the window
    public void setDialogStage(Stage dialogStage){this.dialogStage=dialogStage;}//get the dialoge stage
    public void init(String cinename,AdminPannelControleur apc)
    {
        this.cinename.setText(cinename);
        this.apc=apc;
        int newnumber=this.mainControleur.Cinemas.getCinemaByName(cinename).getAllMovieRooms().size()+1;
        String roomfullName = cinename +" MovieRoom "+ newnumber;
        this.roomname.setText(roomfullName);
        cineplace.textProperty().addListener(new ChangeListener<String>() {//blind the cineplace text file to alow only number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    cineplace.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }

    public void addButon() {//if user add the cinema
        MovieRoom mr = new MovieRoom(this.roomname.getText(),Integer.parseInt(cineplace.getText()),this.mainControleur.Cinemas.getCinemaByName(cinename.getText()).getCinemaId());//create a new room object
        this.mainControleur.Cinemas.getCinemaByName(cinename.getText()).addMovieRoom(mr);//add it to the list
        dialogStage.close();//close the window
        this.apc.setReload();//reload the pages
    }

    public void cancelButon() {
        dialogStage.close();
    }//if user close the page by cliquing on cancel button : close window
}
