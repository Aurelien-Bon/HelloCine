package GUI;

import HelloCiner.Cinema;
import HelloCiner.MovieRoom;
import HelloCiner.filmshow;
import MovieGestion.Collection;
import MovieGestion.Movie;
import info.movito.themoviedbapi.model.MovieDb;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminPannelControleur {

    public ListView<String> listMovie;
    public ChoiceBox<String> cinelist;
    public ChoiceBox<String> roomList;
    public ListView<String> Monday;
    public ListView<String> Tuesday;
    public ListView<String> Wednesday;
    public ListView<String> Thursday;
    public ListView<String> Friday;
    public ListView<String> Saturday;
    public ListView<String> Sunday;
    private mainControleur MainControleur;


    public void setMainApp(mainControleur mainControleur)
    {
        this.MainControleur=mainControleur;
    }

    public void init() {
        for(int i=0;i< this.MainControleur.Cinemas.getCinemas().size();i++)
        {
            cinelist.getItems().add(i,this.MainControleur.Cinemas.getCinemas().get(i).getName());
        }
    }

    public void selectCinema()
    {
        loadCinema();
        loadMovieRoom();
    }

    public void loadCinema() {
        listMovie.getSelectionModel().clearSelection();
        String cine = cinelist.getValue();
        Collection c=new Collection();
        for(var elem:this.MainControleur.Cinemas.getCinemas())
        {
            if(elem.getName().equals(cine))
            {
                c=elem.getCollection();
            }
        }
        ObservableList<String> items = FXCollections.observableArrayList();
        for(var elem:c.getMovieList())
        {
            items.add(elem.getName());
        }
        items.add("Add Movie");
        Collection finalC= c;
        listMovie.setItems(items);
        listMovie.setCellFactory(param -> new ListCell<String>()
        {
            private final ImageView imageView = new ImageView();

            @Override
            public void updateItem(String name, boolean empty)
            {
                super.updateItem(name, empty);
                if (empty)
                {
                    setText(null);
                    setGraphic(null);
                } else
                {
                    String tempName = "";
                    int id=0;
                    if(name.equals("Add Movie"))
                    {
                        Image i = new Image("http://image.noelshack.com/fichiers/2022/12/2/1647983511-plus-sign-symbol-simple-design-vector-25607349.jpg");
                        imageView.setImage(i);
                    }
                    else if(finalC.getMovie(name)!=null)
                    {
                        Image i = finalC.getMovie(name).getMovieImage();
                        imageView.setImage(i);
                    }
                    imageView.setFitHeight(160);
                    imageView.setFitWidth(110);
                    setText(null);
                    if (name.length() > 15)
                    {
                        tempName = (name.substring(0, 12) + "...");
                    }
                    else
                    {
                        tempName=name;
                    }
                    VBox myBox = new VBox(imageView, new Label(tempName));
                    myBox.setAlignment(Pos.BASELINE_CENTER);
                    setGraphic(myBox);
                }
            }
        });
        Collection finalC1 = c;
        listMovie.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2)
            {
                int idmovie = listMovie.getSelectionModel().getSelectedIndex();
                if(idmovie== finalC1.getMovieList().size())
                {
                    this.MainControleur.openAddMovie(cinelist.getValue());
                }
            }
        });
    }

    public void loadMovieRoom()
    {
        String cine = cinelist.getValue();
        roomList.getItems().clear();
        for(var elem:this.MainControleur.Cinemas.getCinemas())
        {
            if(elem.getName().equals(cine))
            {
                for(var pe:elem.getAllMovieRooms())
                {
                    roomList.getItems().add(pe.getName());
                }
            }
        }
    }

    public void loadRoomShedule() {
        String cine = cinelist.getValue();
        String room = roomList.getValue();
        MovieRoom movieRoom = null;
        for (var elem : this.MainControleur.Cinemas.getCinemas()) {
            if (elem.getName().equals(cine)) {
                for (var pe : elem.getAllMovieRooms()) {
                    if (pe.getName().equals(room)) {
                        movieRoom = pe;
                    }
                }
            }
        }
        Monday.getItems().clear();
        Monday.getItems().add("No sceance");
        Monday.getItems().add("No sceance");
        Monday.getItems().add("No sceance");
        Monday.getItems().add("No sceance");
        Monday.getItems().add("No sceance");
        Tuesday.getItems().clear();
        Tuesday.getItems().add("No sceance");
        Tuesday.getItems().add("No sceance");
        Tuesday.getItems().add("No sceance");
        Tuesday.getItems().add("No sceance");
        Tuesday.getItems().add("No sceance");
        Wednesday.getItems().clear();
        Wednesday.getItems().add("No sceance");
        Wednesday.getItems().add("No sceance");
        Wednesday.getItems().add("No sceance");
        Wednesday.getItems().add("No sceance");
        Wednesday.getItems().add("No sceance");
        Thursday.getItems().clear();
        Thursday.getItems().add("No sceance");
        Thursday.getItems().add("No sceance");
        Thursday.getItems().add("No sceance");
        Thursday.getItems().add("No sceance");
        Thursday.getItems().add("No sceance");
        Friday.getItems().clear();
        Friday.getItems().add("No sceance");
        Friday.getItems().add("No sceance");
        Friday.getItems().add("No sceance");
        Friday.getItems().add("No sceance");
        Friday.getItems().add("No sceance");
        Saturday.getItems().clear();
        Saturday.getItems().add("No sceance");
        Saturday.getItems().add("No sceance");
        Saturday.getItems().add("No sceance");
        Saturday.getItems().add("No sceance");
        Saturday.getItems().add("No sceance");
        Sunday.getItems().clear();
        Sunday.getItems().add("No sceance");
        Sunday.getItems().add("No sceance");
        Sunday.getItems().add("No sceance");
        Sunday.getItems().add("No sceance");
        Sunday.getItems().add("No sceance");
        assert movieRoom != null;
        int daynb = 0;
        int hoursnb = 0;
        for (var elem : movieRoom.getAllMovieshow()) {
            String text="Movie : "+elem.getMouvie().getName()+"\n Duration: "+elem.getMouvie().getDuration()+"\n Place left: "+elem.getPlaceTaken();
            if(elem.getHour().equals("10h"))
            {
                hoursnb=0;
            }
            if(elem.getHour().equals("13h"))
            {
                hoursnb=1;
            }
            if(elem.getHour().equals("16h"))
            {
                hoursnb=2;
            }
            if(elem.getHour().equals("19h"))
            {
                hoursnb=3;
            }
            if(elem.getHour().equals("22h"))
            {
                hoursnb=4;
            }

            if (elem.getDay().equals("Monday")) {
                Monday.getItems().set(hoursnb,text);
            }
            if (elem.getDay().equals("Tuesday")) {
                Tuesday.getItems().set(hoursnb,text);
            }
            if (elem.getDay().equals("Wednesday")) {
                Wednesday.getItems().set(hoursnb,text);
            }
            if (elem.getDay().equals("Thursday")) {
                Thursday.getItems().set(hoursnb,text);
            }
            if (elem.getDay().equals("Friday")) {
                Friday.getItems().set(hoursnb,text);
            }
            if (elem.getDay().equals("Saturday")) {
                Saturday.getItems().set(hoursnb,text);
            }
            if (elem.getDay().equals("Sunday")) {
                Sunday.getItems().set(hoursnb,text);
            }
        }
        Monday.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2)
            {
                //filmshow=movieRoom.getMovieShow()
            }
        });
    }
    public void openSeanceView()
    {

        //this.MainControleur.OpenSeanceView(movieRoom);
    }
    public void openAddMovieWindow()
    {
        MainControleur.openAdminPanel();
    }
}
