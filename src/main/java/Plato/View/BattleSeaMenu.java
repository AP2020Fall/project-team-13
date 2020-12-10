package Plato.View;

import Plato.Model.Player;

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

            }
            else if( input.trim().equals("Show log")){

            }
            else if( input.trim().equals("Show wins count")){

            }
            else if( input.trim().equals("Show played count")){

            }
            else if( input.trim().equals("Add to favorites")){

            }
            else if( input.trim().equals("Run game")){

            }
            else if( input.trim().equals("Show point")) {

            }
        }
    }
}
