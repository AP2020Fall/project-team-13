package Plato.View;

import BattleSea.Controller.BattleSea;
import Plato.Controller.LoginPageController;
import Plato.Model.Player;
import Reversi.ReversiController;

import java.util.Scanner;

public class BattleSeaMenu extends Page{
    private static int gameID = 2;
    public Page run() {
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        while(true){
            if(input.trim().equals("Show scoreboard")){

            }
            else if( input.trim().equals("Details")){
                System.out.println("Object of Game\n" +
                        "Sea Battle is a 2 players game where players take turns trying to destroy the other player's fleet of ships on a 10x10 grid:\n" +
                        "\n" +
                        "The game is played in 2 phases: 1. Ship Placement Phase and 2. Attack Phase\n" +
                        "Ship Placement Phase\n" +
                        "At the start of each game, you must place your ships on the ocean grid:\n" +
                        "\n" +
                        "Each player starts out with 6 ships. Below are the ship and their corresponding sizes:\n" +
                        "\n" +
                        "To place a ship, you can tap and drag a ship to any available area.\n" +
                        "You can rotate a ship by simply tapping on it.\n" +
                        "You can also tap on \"Random\" button to randomly assign placement to each ship\n" +
                        "Once you've finished placing your ships, tap on the green \"Ready\" button.\n" +
                        "Attack Phase\n" +
                        "When both players have taped on their \"Ready\" button, the Attack Phase will now start.\n" +
                        "Both players will now see the following game board:\n" +
                        "\n" +
                        "The larger grid in the center represents your opponent's area. The smaller grid at the bottom represents your are and your ships.\n" +
                        "When it is your turn, tap on the square on the main grid you wish to attack. A miss is marked with a white \"X.\" A hit will be marked with a red crosshair marker.\n" +
                        "Every time you hit an enemy ship, you get another turn. When you miss, your turn is over.\n" +
                        "When you've sunk your opponent's ship, that ship will appear on the main grid.\n" +
                        "The first person to sink all five of his/her opponent's ships wins the game.");
            }
            else if( input.trim().equals("Show log")){

            }
            else if( input.trim().equals("Show wins count")){
                System.out.println("player with username " + LoginPageController.user.getUsername() +
                        " has won " + ( (Player)LoginPageController.user).getBattleSeaWins() + " time(s) in BattleSea.");
            }
            else if( input.trim().equals("Show played count")){
                System.out.println("player with username " + LoginPageController.user.getUsername() +
                        " has played " + ( (Player)LoginPageController.user).getBattleSeaPlayedCount() + " time(s) in BattleSea.");
            }
            else if( input.trim().equals("Add to favorites")){
                ((Player)LoginPageController.user).addFavorite(new BattleSea(null));
            }
            else if( input.trim().equals("Run game")){

            }
            else if( input.trim().equals("Show point")) {
                System.out.println("the player with username "
                        + ((Player)LoginPageController.user).getUsername() + " has gained "
                        + ((Player)LoginPageController.user).getBattleSeaWins() + " points from BattleSea.");
            }
        }
    }
}
