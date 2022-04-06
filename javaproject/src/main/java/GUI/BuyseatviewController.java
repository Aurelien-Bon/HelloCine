package GUI;

import HelloCiner.filmshow;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BuyseatviewController {
    public Label numbreChose;
    public Slider slider;
    public Label FilmeShow;
    public AnchorPane placeChose;
    private mainControleur mainControleur;
    private filmshow filmshow;
    private Stage dialogStage;

    public void setMainApp(mainControleur mainControleur)
    {
        this.mainControleur=mainControleur;
    }
    public void init(filmshow filmshow){
        this.filmshow=filmshow;
        slider.setMax(filmshow.getPlaceTaken());
        slider.setMin(0);
        slider.setOnDragDetected(mouseEvent -> {numbreChose.setText(Integer.toString((int)slider.getValue()));});
    }

    public void addticket() {
        filmshow.removePlace(slider.getValue());
        dialogStage.close();
    }

    public void cancel() {
        dialogStage.close();
    }

    public void setDialogStage(Stage dialogStage)
    {
        this.dialogStage=dialogStage;
    }
}
