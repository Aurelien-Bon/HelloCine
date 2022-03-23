package GUI;

import HelloCiner.Cinemas;
import HelloCiner.MovieRoom;
import HelloCiner.filmshow;
import MovieGestion.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class mainControleur {
    public MenuBar menubar;
    @FXML
    private Menu menu;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private BorderPane rootLayout;
    public Cinemas Cinemas;

    public void init() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            stage=new Stage();
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        menubar=new MenuBar();
        MenuItem menuItem = new MenuItem();
        menuItem.setText("Admin Pannel");
        menuItem.setOnAction(event -> openAdminPanel());
        menu = new Menu();
        menu.getItems().add(menuItem);
        menu.setText("Admin");
        menubar.getMenus().setAll(menu);
        this.Cinemas=new Cinemas();
        this.Cinemas.load();

    }

    public void openAddMovieComfirm(Movie movie)
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("addMovieComfirm.fxml"));
            AnchorPane addMovie = loader.load();
            addMovieComfirmControleur controller = loader.getController();
            controller.setMainApp(this);
            controller.init(movie);
            ScrollPane scroll = new ScrollPane();
            scroll.setContent(addMovie);
            rootLayout.setCenter(scroll);
            String title="HelloCine  - Add "+movie.getName()+"?";
            stage.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void openAddMovie(String cinema)
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("addMovie.fxml"));
            AnchorPane addMovie = loader.load();
            addMovieControleur controller = loader.getController();
            controller.setMainApp(this);
            controller.init(cinema);
            ScrollPane scroll = new ScrollPane();
            scroll.setContent(addMovie);
            rootLayout.setCenter(scroll);
            stage.setTitle("Hello cine - Add Movie");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openAdminPanel()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AdminPannel.fxml"));
            AnchorPane AdminPannel = loader.load();
            AdminPannelControleur controller = loader.getController();
            controller.setMainApp(this);
            controller.init();
            ScrollPane scroll = new ScrollPane();
            scroll.setContent(AdminPannel);
            rootLayout.setCenter(scroll);
            stage.setTitle("Hello cine - Admin Pannel");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HelloCine()
    {
        try {
            // Load person overview.

            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("HelloCine.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            HelloCine controller = loader.getController();
            controller.setMainApp(this);
            controller.init();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            stage.setTitle("HelloCine");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Stage getStage() {
        return stage;
    }

    public void OpenSeanceView(filmshow movieRoom) {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("SeanceView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            SceanceViewControleur controller = loader.getController();
            controller.setMainApp(this);
            controller.init();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
            stage.setTitle("HelloCine - SceanceView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
