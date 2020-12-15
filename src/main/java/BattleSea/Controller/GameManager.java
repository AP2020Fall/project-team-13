package BattleSea.Controller;

import BattleSea.Model.Coordination;
import BattleSea.Model.Ship;
import Plato.Model.Player;

import java.security.SecureRandom;
import java.util.ArrayList;

public class GameManager {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private Player turn;
    private int firstPlayerScore;
    private int secondPlayerScore;
    GridManager firstPlayerGridManager;
    GridManager secondPlayerGridManager;
    ShipManager firstPlayerShipManager;
    ShipManager secondPlayerShipManager;

    public GameManager(Player firstPlayer, Player secondPlayer, int boardDimension, int numberOfShips) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        createBoard(boardDimension);
        createShips(boardDimension, numberOfShips);
        turn = firstPlayer;
        firstPlayerScore = 0;
        secondPlayerScore = 0;
    }

    public void addScore(int score, Player player) {
        if (player.equals(firstPlayer)) firstPlayerScore += score;
        else if (player.equals(secondPlayer)) secondPlayerScore += score;
    }

    private void createBoard(int boardDimension) {
        firstPlayerGridManager = new GridManager(firstPlayer, boardDimension);
        secondPlayerGridManager = new GridManager(secondPlayer, boardDimension);
    }

    private void createShips(int boardDimension, int numberOfShips) {
        firstPlayerShipManager = new ShipManager(firstPlayer, boardDimension, numberOfShips);
        secondPlayerShipManager = new ShipManager(secondPlayer, boardDimension, numberOfShips);
        putTheShipsOnBoardRandomly(firstPlayerGridManager,firstPlayerShipManager,boardDimension);
        putTheShipsOnBoardRandomly(secondPlayerGridManager,secondPlayerShipManager,boardDimension);
    }

    public String bombLocation(int xAxis, int yAxis) {
        if (firstPlayerGridManager.getPlayerGrid().getDimension() < xAxis || firstPlayerGridManager.getPlayerGrid().getDimension() < yAxis)
            return "Please Choose a Location Inside The Game Board";
        if (turn.equals(firstPlayer)) {
            return bombLocationByPlayer(xAxis,yAxis,firstPlayerGridManager,firstPlayerShipManager,secondPlayerGridManager,secondPlayerShipManager);
        } else {
            return bombLocationByPlayer(xAxis, yAxis, secondPlayerGridManager, secondPlayerShipManager, firstPlayerGridManager, firstPlayerShipManager);
        }
    }

    public String changeLocationOfShip(int shipCode, int xAxis, int yAxis) {
        if (turn.equals(firstPlayer)) {
            if (firstPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !firstPlayerShipManager.getShipByShipCode(shipCode).isMovable())
                return "This Ship Cannot Move Because It Is Partially or Completely destroyed";
        } else if (secondPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !secondPlayerShipManager.getShipByShipCode(shipCode).isMovable())
            return "This Ship Cannot Move Because It Is Partially or Completely destroyed";
        try {
            if (turn.equals(firstPlayer)) {
                if (firstPlayerGridManager.changeLocationOfShip(firstPlayerShipManager.getShipByShipCode(shipCode), xAxis, yAxis)) {
                    return "The Ship " + shipCode + " Has Been Moved To The New Location Successfully";
                } else return "Cannot Move The Ship To The Requested Location! Try A New Location";
            } else {
                if (secondPlayerGridManager.changeLocationOfShip(secondPlayerShipManager.getShipByShipCode(shipCode), xAxis, yAxis)) {
                    return "The Ship " + shipCode + " Has Been Moved To The New Location Successfully";
                } else return "Cannot Move The Ship To The Requested Location! Try A New Location";
            }
        } catch (IndexOutOfBoundsException e) {
            firstPlayerGridManager.fixTheGrid();
            secondPlayerGridManager.fixTheGrid();
            return "You Cannot Move The Ship To This Location! Because Part Of Ship Will Be Out Of The Board. Try A New Location";
        }
    }

    public String changeDirectionOfShip(int shipCode,char newDirection){
        if (turn.equals(firstPlayer)) {
            if (firstPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !firstPlayerShipManager.getShipByShipCode(shipCode).isMovable())
                return "This Ship Cannot Rotate Because It Is Partially or Completely destroyed";
        } else if (secondPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !secondPlayerShipManager.getShipByShipCode(shipCode).isMovable())
            return "This Ship Cannot Rotate Because It Is Partially or Completely destroyed";
        try {
            if (turn.equals(firstPlayer)) {
                if (firstPlayerGridManager.changeDirectionOfShip(firstPlayerShipManager.getShipByShipCode(shipCode),newDirection)) {
                    return "The Ship " + shipCode + " Has Been Rotated To The New Direction Successfully";
                } else return "Cannot Rotate The Ship To The Requested Direction! Try A New One";
            } else {
                if (secondPlayerGridManager.changeDirectionOfShip(secondPlayerShipManager.getShipByShipCode(shipCode),newDirection)) {
                    return "The Ship " + shipCode + " Has Been Rotated To The New Direction Successfully";
                } else return "Cannot Rotate The Ship To The Requested Direction! Try A New One";
            }
        } catch (IndexOutOfBoundsException e) {
            firstPlayerGridManager.fixTheGrid();
            secondPlayerGridManager.fixTheGrid();
            return "You Cannot Move The Ship To This Location! Because Part Of Ship Will Be Out Of The Board. Try Another Direction";
        }
    }

    private String bombLocationByPlayer(int xAxis,int yAxis,GridManager playerGridManager,ShipManager playerShipManager,GridManager opponentGridManager,ShipManager opponentShipManager){
        if (playerGridManager.bombLocation(xAxis, yAxis, turn, playerShipManager)) {
            if (opponentGridManager.bombLocation(xAxis, yAxis, turn, opponentShipManager)) {
                addScore(1, turn);
                if (opponentShipManager.isAnyShipDestroyed(opponentGridManager)) {
                    addScore(5, turn);
                    return "You Destroyed Your Opponent's Ship";
                }
                return "Your Bomb Hit The Opponent's Ship";
            } else {
                changeTurn();
                return "You Missed Your Shot";
            }
        } else return "You Have Already Bombed This Location! Choose Another Location";
    }

    private void changeTurn(){
        if (turn.equals(firstPlayer)) turn=secondPlayer;
        else turn=firstPlayer;
        System.out.println("Next Player's Turn!");
    }

    public void putTheShipsOnBoardRandomly(GridManager gridManager,ShipManager shipManager,int boardDimension) {
        for (Ship ship : shipManager.getAllShips()) {
            ship.setStartPoint(new Coordination(randomNumber(boardDimension),randomNumber(boardDimension)));
            int temp=randomNumber(4);
            if (temp==0) ship.setDirection('n');
            else if (temp==1) ship.setDirection('e');
            else if (temp==2) ship.setDirection('s');
            else ship.setDirection('w');
            putThisShipOnBoard(ship,gridManager,boardDimension);
        }
    }

    private void putThisShipOnBoard(Ship ship,GridManager gridManager,int boardDimension){
        try{
            gridManager.changeLocationOfShip(ship,randomNumber(boardDimension),randomNumber(boardDimension));
        } catch (IndexOutOfBoundsException e) {
            putThisShipOnBoard(ship,gridManager,boardDimension);
        }
    }

    private int randomNumber(int max){
        SecureRandom rand=new SecureRandom();
        return rand.nextInt(max);
    }
}
