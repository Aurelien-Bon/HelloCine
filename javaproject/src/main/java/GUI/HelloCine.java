package GUI;

public class HelloCine {
    private mainControleur MainControleur;

    public void setMainApp(mainControleur mainControleur)
    {
        this.MainControleur=mainControleur;
    }
    public void openAdminPannelWindow()
    {
        MainControleur.openAdminPanel();
    }

    public void init() {
    }
}
