package Plato.View;

import Plato.Controller.GamesMenuController;

public class GamesMenu extends Page{
    private static GamesMenu gamesMenu = new GamesMenu();
    private GamesMenuController gamesMenuController = GamesMenuController.getInstance();
    public Page run() {
        gamesMenuController.getGamesController();
        return null;
    }
}
