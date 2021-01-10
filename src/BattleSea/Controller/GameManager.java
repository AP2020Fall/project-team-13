package BattleSea.Controller;

import BattleSea.Model.Coordination;
import BattleSea.Model.Grid;
import BattleSea.Model.Ship;
import BattleSea.View.InGameMenu;
import Plato.Model.Player;

import java.io.IOException;
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
        putTheShipsOnBoardRandomly(firstPlayerGridManager, firstPlayerShipManager, boardDimension);
        putTheShipsOnBoardRandomly(secondPlayerGridManager, secondPlayerShipManager, boardDimension);
    }

    public int bombLocation(int xAxis, int yAxis) {
        if (turn.equals(firstPlayer)) {
            return bombLocationByPlayer(xAxis, yAxis, firstPlayerGridManager, firstPlayerShipManager, secondPlayerGridManager, secondPlayerShipManager);
        } else {
            return bombLocationByPlayer(xAxis, yAxis, secondPlayerGridManager, secondPlayerShipManager, firstPlayerGridManager, firstPlayerShipManager);
        }
    }

    public int changeLocationOfShip(int shipCode, int xAxis, int yAxis) {
        if (turn.equals(firstPlayer)) {
            if (firstPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !firstPlayerShipManager.getShipByShipCode(shipCode).isMovable())
                return 0;
        } else if (secondPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !secondPlayerShipManager.getShipByShipCode(shipCode).isMovable())
            return 0;
        try {
            if (turn.equals(firstPlayer)) {
                if (firstPlayerGridManager.changeLocationOfShip(firstPlayerShipManager.getShipByShipCode(shipCode), xAxis, yAxis)) {
                    return 1;
                } else return 2;
            } else {
                if (secondPlayerGridManager.changeLocationOfShip(secondPlayerShipManager.getShipByShipCode(shipCode), xAxis, yAxis)) {
                    return 1;
                } else return 2;
            }
        } catch (IndexOutOfBoundsException e) {
            firstPlayerGridManager.fixTheGrid();
            secondPlayerGridManager.fixTheGrid();
            return 3;
        }
    }

    public int changeDirectionOfShip(int shipCode, char newDirection) {
        if (turn.equals(firstPlayer)) {
            if (firstPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !firstPlayerShipManager.getShipByShipCode(shipCode).isMovable())
                return 0;
        } else if (secondPlayerShipManager.getShipByShipCode(shipCode).isDestroyed() || !secondPlayerShipManager.getShipByShipCode(shipCode).isMovable())
            return 0;
        try {
            if (turn.equals(firstPlayer)) {
                if (firstPlayerGridManager.changeDirectionOfShip(firstPlayerShipManager.getShipByShipCode(shipCode), newDirection)) {
                    return 1;
                } else return 2;
            } else {
                if (secondPlayerGridManager.changeDirectionOfShip(secondPlayerShipManager.getShipByShipCode(shipCode), newDirection)) {
                    return 1;
                } else return 2;
            }
        } catch (IndexOutOfBoundsException e) {
            firstPlayerGridManager.fixTheGrid();
            secondPlayerGridManager.fixTheGrid();
            return 3;
        }
    }

    private int bombLocationByPlayer(int xAxis, int yAxis, GridManager playerGridManager, ShipManager playerShipManager, GridManager opponentGridManager, ShipManager opponentShipManager) {
        if (playerGridManager.bombLocation(xAxis, yAxis, turn, playerShipManager)) {
            if (opponentGridManager.bombLocation(xAxis, yAxis, turn, opponentShipManager)) {
                addScore(1, turn);
                playerGridManager.wasBombingLocationSuccessful(true, xAxis, yAxis);
                int destroyedShipCode = opponentShipManager.isAnyShipDestroyed(opponentGridManager);
                if (!(destroyedShipCode == -1)) {
                    addScore(5, turn);
                    playerGridManager.destroyShip(opponentShipManager.getShipByShipCode(destroyedShipCode), turn);
                    opponentGridManager.destroyShip(opponentShipManager.getShipByShipCode(destroyedShipCode), turn);
                    if (opponentShipManager.areAllShipsDestroyed()) InGameMenu.gameHasEnded();
                    return 2;
                }
                return 1;
            } else {
                playerGridManager.wasBombingLocationSuccessful(false, xAxis, yAxis);
                changeTurn();
                return 0;
            }
        } else {
            if (playerGridManager.isTheGridFullyBombed() && opponentGridManager.isTheGridFullyBombed())
                InGameMenu.gameHasEnded();
            return 3;
        }
    }

    public void changeTurn() {
        if (turn.equals(firstPlayer)) turn = secondPlayer;
        else turn = firstPlayer;
    }

    public void putTheShipsOnBoardRandomly(GridManager gridManager, ShipManager shipManager, int boardDimension) {
        for (Ship ship : shipManager.getAllShips()) {
            ship.setStartPoint(new Coordination(randomNumber(boardDimension) + 1, randomNumber(boardDimension) + 1));
            int temp = randomNumber(4);
            if (temp == 0) ship.setDirection('n');
            else if (temp == 1) ship.setDirection('e');
            else if (temp == 2) ship.setDirection('s');
            else ship.setDirection('w');
            putThisShipOnBoard(ship, gridManager, boardDimension);

        }
    }

    private void putThisShipOnBoard(Ship ship, GridManager gridManager, int boardDimension) {
        try {
            while (!gridManager.changeLocationOfShip(ship, randomNumber(boardDimension) + 1, randomNumber(boardDimension) + 1)) {
                gridManager.fixTheGrid();
            }
        } catch (IndexOutOfBoundsException e) {
            gridManager.fixTheGrid();
            putThisShipOnBoard(ship, gridManager, boardDimension);
        }
    }

    private int randomNumber(int max) {
        SecureRandom rand = new SecureRandom();
        return rand.nextInt(max);
    }

    public Player getTurn() {
        return turn;
    }

    public GridManager getFirstPlayerGridManager() {
        return firstPlayerGridManager;
    }

    public GridManager getSecondPlayerGridManager() {
        return secondPlayerGridManager;
    }

    public ShipManager getFirstPlayerShipManager() {
        return firstPlayerShipManager;
    }

    public ShipManager getSecondPlayerShipManager() {
        return secondPlayerShipManager;
    }

    public Grid getTurnsOwnBoard() {
        if (turn.equals(firstPlayer)) return firstPlayerGridManager.getPlayerGrid();
        else return secondPlayerGridManager.getPlayerGrid();
    }

    public Grid getTurnsOpponentBoard() {
        if (turn.equals(firstPlayer)) return firstPlayerGridManager.getOpponentGrid();
        else return secondPlayerGridManager.getOpponentGrid();
    }

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public int getFirstPlayerScore() {
        return firstPlayerScore;
    }

    public int getSecondPlayerScore() {
        return secondPlayerScore;
    }

    public void withdraw() {
        if (turn.equals(firstPlayer)) firstPlayerScore = -10;
        else secondPlayerScore = -10;
        InGameMenu.gameHasEnded();
    }

    public void clearScreen() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public ArrayList<String> getShips(int option) {
        if (turn.equals(firstPlayer)) {
            return getShipsOfPlayer(option, firstPlayerShipManager);
        } else {
            return getShipsOfPlayer(option, secondPlayerShipManager);
        }
    }

    private ArrayList<String> getShipsOfPlayer(int option, ShipManager playerShipManager) {
        ArrayList<String> ships = new ArrayList<>();
        for (Ship ship : playerShipManager.getAllShips()) {
            if (option == 1) {
                ships.add("ship " + ship.getCode());
            } else if (option == 2 && ship.isMovable()) {
                ships.add("ship " + ship.getCode());
            } else if (option == 3 && !ship.isMovable() && !ship.isDestroyed()) {
                ships.add("ship " + ship.getCode());
            } else if (option == 4 && ship.isDestroyed()) {
                ships.add("ship " + ship.getCode());
            }
        }
        return ships;
    }
}
