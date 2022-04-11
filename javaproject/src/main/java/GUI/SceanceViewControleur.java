package GUI;

import HelloCiner.Cinema;
import HelloCiner.filmshow;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceanceViewControleur {
    public Label seancetitle;
    public Label CinemaMovieRoom;
    public ChoiceBox<String> CollectionList;
    public TextField price;
    private mainControleur MainControleur;
    private filmshow movieRoom;
    private Cinema cinema;
    private Stage dialogStage;
    private AdminPannelControleur apc;

    public void setMainApp(mainControleur mainControleur) {
        this.MainControleur=mainControleur;
    }//set the main app
    public void setDialogStage(Stage dialogStage){this.dialogStage=dialogStage;}//get the acctual window

    public void init(filmshow movieRoom,AdminPannelControleur apc) {
        this.movieRoom=movieRoom;
        this.apc=apc;
        String title="Session of "+this.movieRoom.getDay()+" at "+this.movieRoom.getHour();//print the session name
        seancetitle.setText(title);
        String cineMovie="";
        for(var elem:MainControleur.Cinemas.getCinemas())//get all the cinema
        {
            for(var me:elem.getAllMovieRooms())//get all the movie
            {
                if(me.getName().equals(this.movieRoom.getSalleName()))//if the movie is in this movie room
                {
                    this.cinema=elem;
                    cineMovie=elem.getName()+" - "+me.getName();//get the movie name
                }
            }
        }
        CinemaMovieRoom.setText(cineMovie);//print the movie name
        price.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    price.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        price.setText(Integer.toString(this.movieRoom.getPrice()));//print the movie price
        for(var elem:cinema.getCollection().getMovieList())
        {
            CollectionList.getItems().add(elem.getName());//get all the movie
        }
        if(movieRoom.getMouvie() != null)
        {
            CollectionList.setValue(movieRoom.getMouvie().getName());
            dialogStage.showAndWait();
        }
        else if(cinema.Collection.getMovieList().size()!=0)
        {
            CollectionList.setValue(CollectionList.getItems().get(0));
            dialogStage.showAndWait();
        }
        else
        {
            MainControleur.openAddMovie(cinema.getName());
            dialogStage.close();
        }
    }
    public void onCancelButton()
    {
        dialogStage.close();
    }//close the window

    public void onAddButton() {
        movieRoom.setPrice(Integer.parseInt(price.getText()));//set the price
        movieRoom.setMouvie(cinema.getCollection().getMovie(CollectionList.getValue()));//set the movie name
        movieRoom.setNbPlace(cinema.getMovieRooms(movieRoom.getSalleName()).getCapacity());//set the number place
        for(var elem:MainControleur.Cinemas.getCinemas())
        {
            if(elem.equals(cinema))
            {
                for(var me:elem.getAllMovieRooms())
                {
                    if(me.getName().equals(movieRoom.getSalleName()))
                    {
                        me.addMovieShow(movieRoom);//add the new movie show
                    }
                }
            }
        }
        dialogStage.close();//close the window
        apc.setReload();//reload the app
    }
}
