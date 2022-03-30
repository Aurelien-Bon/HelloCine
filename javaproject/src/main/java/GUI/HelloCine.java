package GUI;

import MovieGestion.Collection;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

import java.util.Objects;

public class HelloCine {
    public AnchorPane ancorepane;
    public ListView<String> movieToSee;
    public ChoiceBox<String> Cinelist;
    public AnchorPane sceancelisttoprinte;
    public WebView trileurView;
    public Label overview;
    public Label adressprinter;
    private mainControleur MainControleur;
    @FXML
    private ListView<String> sceanceList;

    public void setMainApp(mainControleur mainControleur)
    {
        this.MainControleur=mainControleur;
    }
    public void openAdminPannelWindow()
    {
        MainControleur.openAdminPanel();
    }
    public void init(boolean admin) {
        if(admin)
        {
            Button boutton=new Button();
            boutton.setText("Admin");
            boutton.setOnAction(event -> {openAdminPannelWindow();});
            ancorepane.getChildren().add(boutton);
        }
        Cinelist.getItems().add("All Cinema");
        for(var elem:MainControleur.Cinemas.getCinemas())
        {
            Cinelist.getItems().add(elem.getName());
        }
        Cinelist.setOnAction( event -> {loadCinema();});
        Cinelist.setValue("All Cinema");
    }
    public void loadCinema()
    {
        movieToSee.getItems().clear();
        Collection c=new Collection();
        if(!Objects.equals(Cinelist.getValue(), "All Cinema"))
        {
            for(var elem:MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getCollection().getMovieList())
            {
                c.setMovie(elem);
            }
            String adress="Adress: "+MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getAdress();
            adressprinter.setText(adress);
        }
        else
        {
            adressprinter.setText("");
            for(var elem:MainControleur.Cinemas.getCinemas())
            {
                for(var me:elem.getCollection().getMovieList())
                {
                    if(c.getMovie(me.getName())==null)
                    {
                        c.setMovie(me);
                    }
                }
            }
        }
        for(var elem:c.getMovieList())
        {
            movieToSee.getItems().add(elem.getName());
        }
        movieToSee.setCellFactory(param -> new ListCell<String>()
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
                    if(c.getMovie(name)!=null)
                    {
                        Image i = c.getMovie(name).getMovieImage();
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
        movieToSee.setOnMouseClicked(mouseEvent -> {
           afficheSceance();
        });
    }

    public void afficheSceance()
    {
        sceanceList.getItems().clear();
        if(!Objects.equals(Cinelist.getValue(), "All Cinema"))
        {
            for(var elem:MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getAllMovieRooms())
            {
                for(var me:elem.getAllMovieshow())
                {
                    if(Objects.equals(me.getMouvie().getName(), movieToSee.getSelectionModel().getSelectedItem()))
                    {
                        String sceance= me.getDay()+"\n"+me.getHour()+"00\n£"+me.getPrice();
                        sceanceList.getItems().add(sceance);
                    }
                }
            }
            for(var elem:MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getCollection().getMovieList())
            {
                if(elem.getName().equals(movieToSee.getSelectionModel().getSelectedItem()))
                {
                    overview.setText(elem.getOverview());
                    trileurView.getEngine().load(elem.getTraileurLink());
                }
            }
        }
        else
        {
            for(var cin:MainControleur.Cinemas.getCinemas())
            {
                for(var elem:cin.getAllMovieRooms())
                {
                    for(var me:elem.getAllMovieshow())
                    {
                        if(Objects.equals(me.getMouvie().getName(), movieToSee.getSelectionModel().getSelectedItem()))
                        {
                            boolean insind=false;
                            for(var mr:sceanceList.getItems())
                            {
                                if(mr.equals(me.getMouvie().getName()))
                                {
                                    insind=true;
                                }
                            }
                            if(!insind)
                            {
                                String sceance= me.getDay()+"\n"+me.getHour()+"00\n£"+me.getPrice();
                                sceanceList.getItems().add(sceance);
                            }
                        }
                    }
                }
            }
            for(var elem:MainControleur.Cinemas.getCinemas())
            {
                for(var me:elem.getCollection().getMovieList())
                {
                    if(me.getName().equals(movieToSee.getSelectionModel().getSelectedItem()))
                    {
                        overview.setText(me.getOverview());
                        trileurView.getEngine().load(me.getTraileurLink());
                    }
                }
            }
        }
    }
}
