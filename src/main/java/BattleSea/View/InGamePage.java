package BattleSea.View;

import Plato.Model.Player;

import java.util.Scanner;

public class InGamePage {
    private final Player owner;
    private Scanner inputScanner;

    public InGamePage(Player owner, Scanner inputScanner) {
        this.owner = owner;
        this.inputScanner = inputScanner;
    }


    public void changeDirection(int shipCode){

    }

    public void changeLocation(int shipCode,int xDestination,int yDestination){

    }

    public void bombLocation(int xAxis,int yAxis){

    }

    public void showPlayerGameBoard(){

    }

    public void showOpponentGameBoard(){

    }

    public void showShips(){

    }

    public void showBombardLocations(String setting){

    }

    public void showScores(){

    }
}
