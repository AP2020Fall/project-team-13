package Plato.View;

import Plato.Controller.MainPagePlayerController;

public class MainPagePlayer extends Page{
    public static MainPagePlayer mainPagePlayer = new MainPagePlayer();
    private MainPagePlayerController mainPagePlayerController = MainPagePlayerController.getInstance();
    public Page run() {
        mainPagePlayerController.showPointController();
        return null;
    }
}
