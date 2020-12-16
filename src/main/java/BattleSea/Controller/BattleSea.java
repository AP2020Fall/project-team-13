package BattleSea.Controller;

import BattleSea.View.StartingPage;
import Plato.Model.Game;
import Plato.Model.Player;

public class BattleSea extends Game {
    public static BattleSea battleSea = new BattleSea();
    private  Player firstPlayer;
    private  Player secondPlayer;

    public static void main(String[] args) {
        Player player1=new Player();
        Player player2=new Player();
        player1.setFirstname("ali");
        player1.setLastname("dehghani");
        player2.setFirstname("mehdi");
        player2.setLastname("abdi");
        new BattleSea(player1,player2).run();
    }

    public BattleSea(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;

    }

    public BattleSea() {

    }

    public void run(){
        new StartingPage(firstPlayer,secondPlayer).run();
    }
}
