package GUI;

import HelloCiner.Cinema;
import HelloCiner.filmshow;
import MovieGestion.Collection;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SceanceViewControleur {
    public Label seancetitle;
    public Label CinemaMovieRoom;
    public ChoiceBox<String> CollectionList;
    public TextArea price;
    private mainControleur MainControleur;
    private filmshow movieRoom;
    private Cinema cinema;
    private Stage dialogStage;

    public void setMainApp(mainControleur mainControleur) {
        this.MainControleur=mainControleur;
    }
    public void setDialogStage(Stage dialogStage){this.dialogStage=dialogStage;}

    public void init(filmshow movieRoom) {
        this.movieRoom=movieRoom;
        String title="Session of "+this.movieRoom.getDay()+" at "+this.movieRoom.getHour();
        seancetitle.setText(title);
        String cineMovie="";
        for(var elem:MainControleur.Cinemas.getCinemas())
        {
            for(var me:elem.getAllMovieRooms())
            {
                if(me.getName().equals(this.movieRoom.getSalleName()))
                {
                    this.cinema=elem;
                    cineMovie=elem.getName()+" - "+me.getName();
                }
            }
        }
        CinemaMovieRoom.setText(cineMovie);
        price.setText(Integer.toString(this.movieRoom.getPrice()));
        for(var elem:cinema.getCollection().getMovieList())
        {
            CollectionList.getItems().add(elem.getName());
        }
    }
    public void onCancelButton()
    {
        dialogStage.close();
    }

    public void onAddButton() {
        movieRoom.setPrice(Integer.parseInt(price.getText()));
        movieRoom.setMouvie(cinema.getCollection().getMovie(CollectionList.getValue()));
        movieRoom.setNbPlace(cinema.getMovieRooms(movieRoom.getSalleName()).getCapacity());
        for(var elem:MainControleur.Cinemas.getCinemas())
        {
            if(elem.equals(cinema))
            {
                for(var me:elem.getAllMovieRooms())
                {
                    if(me.getName().equals(movieRoom.getSalleName()))
                    {
                        me.addMovieShow(movieRoom);
                    }
                }
            }
        }
        dialogStage.close();
    }
}
