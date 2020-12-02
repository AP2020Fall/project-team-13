package Plato.Controller;

import Plato.Model.Log;
import Plato.Model.Player;

public class GameMenuController {
    private static GameMenuController gameMenuController = new GameMenuController();
    private int gameID;

    public static GameMenuController getInstance() {
        return gameMenuController;
    }

    public void setGameName(int gameID1){
        this.gameID=gameID1;
    }
    public String showScoreBoard(){
        Player player = (Player) LoginPageController.user;
        Log log = player.getLog(gameID);
        return null;
    }
}
