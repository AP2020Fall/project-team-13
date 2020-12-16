package BattleSea.Controller;

import Plato.Model.Game;
import Plato.Model.Player;

public class BattleSea extends Game {
    public static BattleSea battleSea = new BattleSea();
    private  Player firstPlayer;
    private  Player secondPlayer;

    public BattleSea(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

    }

    public BattleSea() {

    }


}
