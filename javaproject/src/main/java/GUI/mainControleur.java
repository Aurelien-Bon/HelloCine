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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.util.List;

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
            stage.setTitle("HelloCine - Add Movie");
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
            stage.setTitle("HelloCine - Admin Pannel");
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
            controller.init(true);
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

    public void OpenSeanceView(filmshow movieRoom, AdminPannelControleur apc) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("SceanceView.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Session");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            SceanceViewControleur controller = loader.getController();
            controller.setMainApp(this);
            controller.setDialogStage(dialogStage);
            // Show the dialog and wait until the user closes it
            controller.init(movieRoom,apc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void OpenaddCinema(AdminPannelControleur apc) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("addCinema.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("HelloCine - Add new Cinema");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddCinemaControleur controller = loader.getController();
            controller.setMainApp(this);
            controller.init(apc);
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void OpenaddMovieRoom(String cinename,AdminPannelControleur apc) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("addMovieRoom.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("HelloCine - Add new Cinema Room");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            AddMovieRoomControler controller = loader.getController();
            controller.setMainApp(this);
            controller.init(cinename,apc);
            controller.setDialogStage(dialogStage);
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
