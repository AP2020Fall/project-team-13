package Plato.View;

import Plato.Controller.MainPagePlayerController;

public class MainPagePlayer extends Page{
    MainPagePlayerController mainPagePlayerController;
    protected Page run() {
        mainPagePlayerController.showPointController();
        return null;
    }
}
