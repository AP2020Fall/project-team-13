package Plato.View;

import Plato.Controller.LoginPageController;
import Plato.Model.Player;

import java.util.Scanner;

public class GamesMenu extends Page{
    private Player player;
    public Page run() {

    System.out.println("choose one:\n" +
            "1.Reversi\n" +
            "2.Battle sea\n");
        Scanner scanner = new Scanner(System.in);
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input == 1) {
                ReversiMenu game = new ReversiMenu();
                return game;
            } else if (input == 2) {
                BattleSeaMenu game = new BattleSeaMenu();
                return game;
            } else {
                System.out.println("You should select 1 or 2!");
            }
        }
    }

}
