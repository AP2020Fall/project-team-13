package Plato.Controller;

import Plato.Model.Log;
import Plato.Model.Player;

public class GameMenuController {
    private int gameID;
    public void setGameName(int gameID1){
        this.gameID=gameID1;
    }
    public String showScoreBoard(Player player){
        Log log = player.getLog(gameID);
        return null;
    }
}
