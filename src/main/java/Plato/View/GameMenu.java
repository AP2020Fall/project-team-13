package Plato.View;

import Plato.Controller.GameMenuController;

public class GameMenu extends Page{
    GameMenuController gameMenuController;
    protected Page run() {
        gameMenuController.showScoreBoard();
        return null;
    }
}
