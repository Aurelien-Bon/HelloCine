package GUI;

import MovieGestion.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Multi;
import info.movito.themoviedbapi.model.Video;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class addMovieControleur {

    private mainControleur MainControleur;


    public TextField contend;
    private final List<Integer> listID=new ArrayList<>();
    public ListView<String> listView1;
    private String cineName;



    public void setMainApp(mainControleur mainControleur) {//set main app
        this.MainControleur=mainControleur;
    }

    public void init(String cineName) {
        this.cineName=cineName;
    }//get the cinema to add the movie
    @FXML
    protected void search()//on search
    {

        String seclectCine = this.cineName;
        int cinemaID=0;
        for(var elem:this.MainControleur.Cinemas.getCinemas())
        {
            if(elem.getName().equals(seclectCine))//get the cinema
            {
                cinemaID=elem.getCinemaId();
            }
        }
        ObservableList<String> items = FXCollections.observableArrayList();
        List<MovieDb> LM=new ArrayList<>();
        String text;
        TmdbApi api=new TmdbApi("6f4e9f91fcee70ab233126aaab13fc36");//use the TMDB api to search
        TmdbSearch search=new TmdbSearch(api);
        text=contend.getText();
        TmdbSearch.MultiListResultsPage resultsPage=search.searchMulti(text,"en",1);//search on tmdb
        List<Multi> r =resultsPage.getResults();
        int id=0;
        listID.clear();
        for(var elem:r)
        {
            if(elem.getClass().getName().equals("info.movito.themoviedbapi.model.MovieDb"))//select only the movie from the search
            {
                MovieDb m=(MovieDb) elem;
                listID.add(m.getId());
                LM.add(m);
            }
        }
        for (int i = 0; i < listID.size(); i++)
        {
            items.add(LM.get(i).getTitle());
        }
        listView1.setItems(items);//add all the movie search name
        listView1.setCellFactory(param -> new ListCell<String>()//refactor the list view to add the movie image on top of the movie name
        {
            private final ImageView imageView = new ImageView();

            @Override
            public void updateItem(String name, boolean empty)//for evrey cell
            {
                super.updateItem(name, empty);
                if (empty)//if cell is empty
                {
                    setText(null);
                    setGraphic(null);
                } else
                {
                    String tempName;
                    int id=0;
                    for(int i=0;i<LM.size();i++)//get the movie name
                    {
                        if(LM.get(i).getTitle().equals(name))
                        {
                            id=i;
                        }
                    }
                    String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2"+LM.get(id).getPosterPath();//get the movie image
                    Image i =new Image(url);
                    imageView.setImage(i);//add the image
                    imageView.setFitHeight(160);
                    imageView.setFitWidth(110);
                    setText(null);
                    if (name.length() > 15)//if name is more than 15 char
                    {
                        tempName = (name.substring(0, 12) + "...");//add ... to the end
                    }
                    else
                    {
                        tempName=name;
                    }
                    VBox myBox = new VBox(imageView, new Label(tempName));//create the box
                    myBox.setAlignment(Pos.BASELINE_CENTER);
                    setGraphic(myBox);//add it to the cell
                }
            }
        });

        int finalCinemaID = cinemaID;
        listView1.setOnMouseClicked(event -> {//set on movie select by a click
            if (event.getClickCount() == 2)//if its a 2 click
            {
                int idmovie = listView1.getSelectionModel().getSelectedIndex();
                MovieDb mv=api.getMovies().getMovie(LM.get(idmovie).getId(),"en");//get the movie info from the site tmdb
                String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2"+mv.getPosterPath();//get the movie image
                int min = mv.getRuntime();
                int h=0;
                while(min>60)
                {
                    min-=60;
                    h++;
                }
                String time = h +"h"+ min;//get the movie duration time
                TmdbMovies movies = new TmdbApi("6f4e9f91fcee70ab233126aaab13fc36").getMovies();
                List<Video> path = movies.getVideos(mv.getId(), "");//get the movie trailler link
                String ytlink = "https://www.youtube.com/embed/"+ path.get(0).getKey();
                Movie movie=new Movie(mv.getId(), finalCinemaID, mv.getTitle(),mv.getOverview(), time,url,ytlink);//create the new movie
                MainControleur.openAddMovieComfirm(movie);//open the window add movie confirm with the new movie
            }
        });
    }
    @FXML
    public void cancelButon()
    {
        MainControleur.openAdminPanel();
    }//go back to the admin panel
}
