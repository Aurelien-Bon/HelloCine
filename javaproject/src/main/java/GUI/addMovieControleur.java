package GUI;

import MovieGestion.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.Multi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
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
    private List<Integer> listID=new ArrayList<>();
    public ListView<String> listView1;
    public ChoiceBox<String> cinemalist;
    private String cineName;



    public void setMainApp(mainControleur mainControleur) {
        this.MainControleur=mainControleur;
    }

    public void init(String cineName) {
        this.cineName=cineName;
    }
    @FXML
    protected void search()
    {

        String seclectCine = this.cineName;
        int cinemaID=0;
        for(var elem:this.MainControleur.Cinemas.getCinemas())
        {
            if(elem.getName().equals(seclectCine))
            {
                cinemaID=elem.getCinemaId();
            }
        }
        ObservableList<String> items = FXCollections.observableArrayList();
        List<MovieDb> LM=new ArrayList<>();
        String text;
        TmdbApi api=new TmdbApi("6f4e9f91fcee70ab233126aaab13fc36");
        TmdbSearch search=new TmdbSearch(api);
        text=contend.getText();
        TmdbSearch.MultiListResultsPage resultsPage=search.searchMulti(text,"en",1);
        List<Multi> r =resultsPage.getResults();
        int id=0;
        listID.clear();
        for(var elem:r)
        {
            if(elem.getClass().getName().equals("info.movito.themoviedbapi.model.MovieDb"))
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
        listView1.setItems(items);
        listView1.setCellFactory(param -> new ListCell<String>()
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
                    for(int i=0;i<LM.size();i++)
                    {
                        if(LM.get(i).getTitle().equals(name))
                        {
                            id=i;
                        }
                    }
                    String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2"+LM.get(id).getPosterPath();
                    Image i =new Image(url);
                    imageView.setImage(i);
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

        int finalCinemaID = cinemaID;
        listView1.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2)
            {
                int idmovie = listView1.getSelectionModel().getSelectedIndex();
                MovieDb mv=api.getMovies().getMovie(LM.get(idmovie).getId(),"en");
                String url = "https://image.tmdb.org/t/p/w600_and_h900_bestv2"+mv.getPosterPath();
                int min = mv.getRuntime();
                int h=0;
                while(min>60)
                {
                    min-=60;
                    h++;
                }
                String time = h +"h"+ min;
                Movie movie=new Movie(mv.getId(), finalCinemaID, mv.getTitle(),mv.getOverview(), time,url);
                MainControleur.openAddMovieComfirm(movie);
            }
        });
    }
    @FXML
    public void cancelButon()
    {
        MainControleur.openAdminPanel();
    }
}
