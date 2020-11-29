package Plato.View;

import Plato.Controller.GamesMenuController;

public class GamesMenu extends Page{
    GamesMenuController gamesMenuController;
    Page run() {
        gamesMenuController.getGamesController();
        return null;
    }
}
