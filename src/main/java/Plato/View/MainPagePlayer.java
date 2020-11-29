package Plato.View;

import Plato.Controller.MainPagePlayerController;

public class MainPagePlayer extends Page{
    MainPagePlayerController mainPagePlayerController;
    Page run() {
        mainPagePlayerController.showPointController();
        return null;
    }
}
