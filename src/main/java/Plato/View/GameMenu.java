package Plato.View;

import Plato.Controller.GameMenuController;

public class GameMenu extends Page{
    GameMenuController gameMenuController;
    Page run() {
        gameMenuController.showScoreBoard();
        return null;
    }
}
