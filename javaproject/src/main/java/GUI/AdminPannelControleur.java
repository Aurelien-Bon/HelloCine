package GUI;

import HelloCiner.MovieRoom;
import HelloCiner.filmshow;
import MovieGestion.Collection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
    private filmshow session;
    private String movietoremove;



    public void setMainApp(mainControleur mainControleur)
    {
        this.MainControleur=mainControleur;
    }//set the main window

    public void setReload()///methode to reload the pages
    {
        String cinevalue=cinelist.getValue();//get the acctual value
        cinelist.getItems().clear();//clear the value
        for(int i=0;i< this.MainControleur.Cinemas.getCinemas().size();i++)//add every cinema
        {
            cinelist.getItems().add(i,this.MainControleur.Cinemas.getCinemas().get(i).getName());
        }
        cinelist.getItems().add("+ Add Cinema");
        if(!cinevalue.equals("+ Add Cinema"))//set the cinema who was already use
        {
            cinelist.setValue(cinevalue);
        }
        else
        {
            cinelist.setValue(cinelist.getItems().get(0));
        }
    }

    public void init() {
        for(int i=0;i< this.MainControleur.Cinemas.getCinemas().size();i++)//get all the cinema name and add it to the list
        {
            cinelist.getItems().add(i,this.MainControleur.Cinemas.getCinemas().get(i).getName());
        }
        cinelist.getItems().add("+ Add Cinema");//add the cinema
        cinelist.setValue(this.MainControleur.Cinemas.getCinemas().get(0).getName());
    }

    private void removeSession(filmshow session) {
        MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).removeMovieShow(session);//remove the session select
        setReload();
    }

    private void afficheSession(filmshow session) {
        if(session!=null)
        {
            MainControleur.OpenSeanceView(session,this);//open the session select
        }
    }
    private filmshow createSession(String day,int hour,String salleName,int salleid)//create a new session
    {
        String hours = switch (hour) {//get the hour of the session
            case 0 -> "10h";
            case 1 -> "13h";
            case 2 -> "16h";
            case 3 -> "19h";
            case 4 -> "22h";
            default -> "null";
        };
        return new filmshow(day,hours,salleName,salleid);//return the session objet create

    }

    public void selectCinema()//print the cinema information
    {
        try {
            if(!cinelist.getValue().equals("+ Add Cinema"))
            {
                loadCinema();
                loadMovieRoom();
            }
            else//user want to create a new cinema
            {
                addCinema();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    private void addCinema() {
        MainControleur.OpenaddCinema(this);
    }//open add cinema window

    public void removeMovie()//remove movie
    {
        MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getCollection().removeMovieByName(movietoremove);//get the movie name
        for(var elem:MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getAllMovieRooms())
        {
            for(var me:elem.getAllMovieshow())
            {
                if(me.getMouvie().getName().equals(movietoremove))//remove the movie from the list
                {
                    removeSession(me);
                }
            }
        }
        setReload();//reload the page
    }

    public void loadCinema() {
        ContextMenu contextMenuMovie=new ContextMenu();

        MenuItem menuItem1 = new MenuItem("Remove Movie");//create the menu when right clique
        menuItem1.setOnAction(event -> removeMovie());
        contextMenuMovie.getItems().add(menuItem1);
        listMovie.getSelectionModel().clearSelection();//clear the list view
        String cine = cinelist.getValue();
        Collection c=new Collection();//create a collection
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
                    setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
                } else
                {
                    setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
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
            else if(event.getButton() == MouseButton.SECONDARY)
            {
                movietoremove=listMovie.getSelectionModel().getSelectedItem();
                contextMenuMovie.show(MainControleur.getStage(),event.getSceneX(),event.getSceneY());
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
        roomList.getItems().add("+ addMovieRoom");
        roomList.setValue(roomList.getItems().get(0));
    }
    public void loadRoom()
    {
        if(roomList.getValue()!=null)
        {
            if (!roomList.getValue().equals("+ addMovieRoom")) {
                loadRoomShedule();
            } else {
                addMovieRoom();
            }
        }
    }

    private void addMovieRoom() {
        MainControleur.OpenaddMovieRoom(cinelist.getValue(),this);
    }

    public void loadRoomShedule() {

        ContextMenu contextMenu1 = new ContextMenu();
        ContextMenu contextMenu2 = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("Add session");
        menuItem1.setOnAction(event -> afficheSession(session));
        contextMenu2.getItems().setAll(menuItem1);
        MenuItem menuItem2 = new MenuItem("Edit session");
        menuItem2.setOnAction(event -> afficheSession(session));
        MenuItem menuItem3 = new MenuItem("Remove Session");
        menuItem3.setOnAction(event -> removeSession(session));
        contextMenu1.getItems().setAll(menuItem2,menuItem3);


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
        Tuesday.getItems().clear();
        Wednesday.getItems().clear();
        Thursday.getItems().clear();
        Friday.getItems().clear();
        Saturday.getItems().clear();
        Sunday.getItems().clear();
        for(int i=0;i<5;i++)
        {
            Monday.getItems().add("No sceance");
            Tuesday.getItems().add("No sceance");
            Wednesday.getItems().add("No sceance");
            Thursday.getItems().add("No sceance");
            Friday.getItems().add("No sceance");
            Saturday.getItems().add("No sceance");
            Sunday.getItems().add("No sceance");
        }
        int hoursnb = 0;
        if(movieRoom!=null)
        {
            for (var elem : movieRoom.getAllMovieshow()) {
                String titleText=elem.getMouvie().getName();
                if(titleText.length()>17)
                {
                    titleText=titleText.substring(0,14)+"...";
                }
                String text="Movie : "+titleText+"\nDuration: "+elem.getMouvie().getDuration()+"\nPlace left: "+elem.getPlaceTaken()+"\nPrice: "+elem.getPrice();
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
        }

        Monday.setOnMouseClicked(event -> {
            if(Monday.getSelectionModel().getSelectedItem().equals("No sceance"))
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=createSession("Monday",Monday.getSelectionModel().getSelectedIndex(),roomList.getValue(),this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).getId());
                    contextMenu2.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }else
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getSelectionModel().getSelectedItem()).getSpecialMovieShow("Monday",Monday.getSelectionModel().getSelectedIndex());
                    contextMenu1.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }
        });
        Tuesday.setOnMouseClicked(event -> {
            if(Tuesday.getSelectionModel().getSelectedItem().equals("No sceance"))
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=createSession("Tuesday",Tuesday.getSelectionModel().getSelectedIndex(),roomList.getValue(),this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).getId());
                    contextMenu2.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }else
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getSelectionModel().getSelectedItem()).getSpecialMovieShow("Tuesday",Tuesday.getSelectionModel().getSelectedIndex());
                    contextMenu1.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }
        });
        Wednesday.setOnMouseClicked(event -> {
            if(Wednesday.getSelectionModel().getSelectedItem().equals("No sceance"))
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=createSession("Wednesday",Wednesday.getSelectionModel().getSelectedIndex(),roomList.getValue(),this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).getId());
                    contextMenu2.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }else
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getSelectionModel().getSelectedItem()).getSpecialMovieShow("Wednesday",Wednesday.getSelectionModel().getSelectedIndex());
                    contextMenu1.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }
        });
        Thursday.setOnMouseClicked(event -> {
            if(Thursday.getSelectionModel().getSelectedItem().equals("No sceance"))
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=createSession("Thursday",Thursday.getSelectionModel().getSelectedIndex(),roomList.getValue(),this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).getId());
                    contextMenu2.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }else
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getSelectionModel().getSelectedItem()).getSpecialMovieShow("Thursday",Thursday.getSelectionModel().getSelectedIndex());
                    contextMenu1.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }
        });
        Friday.setOnMouseClicked(event -> {
            if(Friday.getSelectionModel().getSelectedItem().equals("No sceance"))
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=createSession("Friday",Friday.getSelectionModel().getSelectedIndex(),roomList.getValue(),this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).getId());
                    contextMenu2.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }else
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getSelectionModel().getSelectedItem()).getSpecialMovieShow("Friday",Friday.getSelectionModel().getSelectedIndex());
                    contextMenu1.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }

        });
        Saturday.setOnMouseClicked(event -> {
            if(Saturday.getSelectionModel().getSelectedItem().equals("No sceance"))
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=createSession("Saturday",Saturday.getSelectionModel().getSelectedIndex(),roomList.getValue(),this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).getId());
                    contextMenu2.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }else
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getSelectionModel().getSelectedItem()).getSpecialMovieShow("Saturday",Saturday.getSelectionModel().getSelectedIndex());
                    contextMenu1.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }

        });
        Sunday.setOnMouseClicked(event -> {
            if(Sunday.getSelectionModel().getSelectedItem().equals("No sceance"))
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=createSession("Sunday",Sunday.getSelectionModel().getSelectedIndex(),roomList.getValue(),this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getValue()).getId());
                    contextMenu2.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
            }else
            {
                if(event.getButton() == MouseButton.SECONDARY)
                {
                    session=this.MainControleur.Cinemas.getCinemaByName(cinelist.getValue()).getMovieRooms(roomList.getSelectionModel().getSelectedItem()).getSpecialMovieShow("Sunday",Sunday.getSelectionModel().getSelectedIndex());
                    contextMenu1.show(MainControleur.getStage(),event.getSceneX()+300,event.getSceneY()+50);
                }
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

    public void quitbutton() {
        MainControleur.HelloCine();
    }

    public void modifieUser(ActionEvent event) {
    }
}
