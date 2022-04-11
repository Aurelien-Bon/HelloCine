package GUI;

import MovieGestion.Collection;
import MovieGestion.Movie;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;

import java.util.Objects;

public class HelloCine {
    public AnchorPane ancorepane;
    public ListView<String> movieToSee;
    public ChoiceBox<String> Cinelist;
    public WebView trileurView;
    public Label overview;
    public Label adressprinter;
    public ListView<String> sceanceList;
    public Label movieduration;
    public Label wellcomeMessage;
    private mainControleur MainControleur;
    private Movie movieOnBord;


    public void setMainApp(mainControleur mainControleur)
    {
        this.MainControleur=mainControleur;
    }//set the main window
    public void openAdminPannelWindow()
    {
        MainControleur.openAdminPanel();
    }//for reloding the window
    public void init(boolean admin) {
        String welcome;
        if(this.MainControleur.user.getName().equals(""))//if the user is not log
        {
            welcome="Welcome Guest";
        }
        else//if user is log
        {
            welcome="Welcome "+this.MainControleur.user.getFirstname()+" "+this.MainControleur.user.getName();
        }
        wellcomeMessage.setText(welcome);
        sceanceList.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));//set the backround of the sceance list
        movieToSee.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));//set the backround of the sceance list
        if(admin)//if the user is an admin
        {
            Button boutton=new Button();
            boutton.setText("Admin");//create a button for admin
            boutton.setStyle("-fx-background-color: #EDD826; -fx-border-color: gray; -fx-border-radius: 5px;");
            boutton.setOnAction(event -> openAdminPannelWindow());
            boutton.setMaxSize(62,27);
            ancorepane.getChildren().add(boutton);//print the button
        }
        Cinelist.getItems().add("All Cinema");//create the list of all the cinema for the choice box
        for(var elem:MainControleur.Cinemas.getCinemas())
        {
            Cinelist.getItems().add(elem.getName());
        }
        Cinelist.setOnAction( event -> loadCinema());//set clique action on the choice box
        Cinelist.setValue("All Cinema");
    }
    public void loadCinema()///methode for loading every movie inside the cinema
    {
        movieToSee.getItems().clear();//clear the list
        Collection c=new Collection();
        if(!Objects.equals(Cinelist.getValue(), "All Cinema"))//if a specific cinema is select
        {
            for(var elem:MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getCollection().getMovieList())//get all movie from the specific cinema
            {
                c.setMovie(elem);
            }
            String adress="Address: "+MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getAdress();//print the cinema adress
            adressprinter.setText(adress);
        }
        else//if every cinema is select
        {
            adressprinter.setText("");//remove the address
            for(var elem:MainControleur.Cinemas.getCinemas())
            {
                for(var me:elem.getCollection().getMovieList())//select all the movie from the base
                {
                    if(c.getMovie(me.getName())==null)//if the movie is not in the list add it
                    {
                        c.setMovie(me);//add it
                    }
                }
            }
        }
        for(var elem:c.getMovieList())//set the movie list inside the listview
        {
            movieToSee.getItems().add(elem.getName());
        }
        movieToSee.setCellFactory(param -> new ListCell<>()
        {
            private final ImageView imageView = new ImageView();
            @Override
            public void updateItem(String name, boolean empty)//overide of the listview to add a image on top of the movie name
            {
                super.updateItem(name, empty);
                if (empty)
                {
                    setText(null);
                    setGraphic(null);
                    setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));//set the background for empty cel

                } else
                {
                    setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));//set the background for cel
                    String tempName;
                    if(c.getMovie(name)!=null)//get the movie name
                    {
                        Image i = c.getMovie(name).getMovieImage();//get the image
                        imageView.setImage(i);
                    }
                    imageView.setFitHeight(160);//set the image hight
                    imageView.setFitWidth(110);
                    setText(null);
                    if (name.length() > 15)//if the movie name >15 char
                    {
                        tempName = (name.substring(0, 12) + "...");
                    }
                    else
                    {
                        tempName=name;
                    }
                    VBox myBox = new VBox(imageView, new Label(tempName));
                    myBox.setAlignment(Pos.BASELINE_CENTER);//set the image
                    setGraphic(myBox);
                }
            }
        });
        movieToSee.setOnMouseClicked(mouseEvent -> afficheSceance());//set the action on click on a specific movie
    }

    public void openSceance(String sceanceName)//methode for opening the movie show window for the good one
    {
        String[] s = sceanceName.split("\n");
        for(var elem:MainControleur.Cinemas.getCinemaByName(s[0]).getAllMovieRooms())
        {
            for(var me:elem.getAllMovieshow())
            {
                if(me.getDay().equals(s[1])&&me.getHour().equals(s[2].replace("00",""))&&me.getMouvie().getName().equals(movieOnBord.getName()))
                {
                    this.MainControleur.OpenBuySeat(me);//open the sceance window
                }
            }
        }
    }

    public void afficheSceance()
    {
        sceanceList.getItems().clear();//clear the list
        sceanceList.setOnMouseClicked(mouseEvent -> {
            if(mouseEvent.getClickCount()==2)//if double click on the sceance
            {
                openSceance(sceanceList.getSelectionModel().getSelectedItem());//open the sceance view
            }
        });
        if(!Objects.equals(Cinelist.getValue(), "All Cinema"))//for a specific cinema
        {
            for(var elem:MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getAllMovieRooms())
            {
                for(var me:elem.getAllMovieshow())//get all the movie show
                {
                    if(Objects.equals(me.getMouvie().getName(), movieToSee.getSelectionModel().getSelectedItem())&& me.getPlaceTaken()>0)//if the movie show movie is select
                    {
                        String sceance= Cinelist.getValue()+"\n"+ me.getDay()+"\n"+me.getHour()+"00\n£"+me.getPrice()+"\nPlace left: "+me.getPlaceTaken();//add it to the list
                        sceanceList.getItems().add(sceance);
                    }
                }
            }
            for(var elem:MainControleur.Cinemas.getCinemaByName(Cinelist.getValue()).getCollection().getMovieList())
            {
                if(elem.getName().equals(movieToSee.getSelectionModel().getSelectedItem()))//print the movie info
                {
                    overview.setText(elem.getOverview());//overview
                    trileurView.getEngine().load(elem.getTraileurLink());//trailler
                    movieOnBord=elem;
                    String duration="Duration : "+elem.getDuration();//duration
                    movieduration.setText(duration);
                }
            }
        }
        else//for all  cinema
        {
            for(var cin:MainControleur.Cinemas.getCinemas())
            {
                for(var elem:cin.getAllMovieRooms())
                {
                    for(var me:elem.getAllMovieshow())//get all the movie show
                    {
                        if(Objects.equals(me.getMouvie().getName(), movieToSee.getSelectionModel().getSelectedItem()))//if the movie show movie is select
                        {
                            boolean insind=false;
                            for(var mr:sceanceList.getItems())
                            {
                                if (mr.equals(me.getMouvie().getName())) {//check if the show is not already inside
                                    insind = true;
                                    break;
                                }
                            }
                            if(!insind && me.getPlaceTaken()>0)
                            {
                                String sceance= cin.getName()+"\n"+ me.getDay()+"\n"+me.getHour()+"00\n£"+me.getPrice()+"\nPlace left: "+me.getPlaceTaken();//print the movie show
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
                    if(me.getName().equals(movieToSee.getSelectionModel().getSelectedItem()))//print the movie info
                    {
                        overview.setText(me.getOverview());
                        trileurView.getEngine().load(me.getTraileurLink());
                        movieOnBord=me;
                        String duration="Duration : "+me.getDuration();
                        movieduration.setText(duration);
                    }
                }
            }
        }
    }

    public void logout() {
        this.MainControleur.ConnectionPage();//go back to the connection pages
    }
}
