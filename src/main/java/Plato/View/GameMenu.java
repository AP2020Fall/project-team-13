package Plato.View;

import Plato.Controller.GameMenuController;
import Plato.Controller.GamesMenuController;

public class GameMenu extends Page{
    private static GameMenu gameMenu = new GameMenu();
    private GameMenuController gameMenuController = GameMenuController.getInstance();
    public Page run() {
        gameMenuController.showScoreBoard();
        return null;
    }
}
