package Reversi;

import Plato.Model.Player;

public class ReversiView {
    public static void showWhereToPut(Table table){}
    public void showWhoseTurnIsIt(Table table){
        System.out.println("It is " + table.getWhoseTurn() + "'s turn.");
    }
    public void showResult(Table table){
        System.out.println(table.getResult());
    }
    public void showScore(Player black, Player white){
        System.out.println("Player black named " + black.getFirstname() + " " + black.getLastname() + " has "
                + black.getScore() + "score(s).");
        System.out.println("Player white named " + white.getFirstname() + " " + white.getLastname() + " has "
                + white.getScore() + "score(s).");
    }
    public static void showGrid(){}
    public void showDisks(Table table){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(table.getTable()[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void changeTurn(String whoseTurn){}
}
