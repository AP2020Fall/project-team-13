package BattleSea.Controller;

import BattleSea.Model.Grid;
import BattleSea.Model.Ship;
import Plato.Model.Player;

import java.util.ArrayList;

public class ShipManager {
    private ArrayList<Ship> allShips;
    private final Player owner;

    public ShipManager(Player owner, int gridDimension, int numberOfShips) {
        this.owner = owner;
        createShips(gridDimension, numberOfShips);
        putTheShipsOnBoardRandomly();
    }

    public boolean changeDirection(int shipCode, char direction, GridManager playerGridManager) {
        return true;
    }

    public boolean changeLocation(int shipCode, int xDestination, int yDestination, GridManager playerGridManager) {
        return true;
    }

    public ArrayList<Ship> getAllShips() {
        return allShips;
    }

    public Ship getShipByShipCode(int shipCode) {
        return allShips.get(shipCode - 1);
    }

    public boolean isAnyShipDestroyed() {
        /*for (Ship ship : allShips) {
            if (!ship.isDestroyed())
        }*/
        return true;
    }

    private void createShips(int gridDimension, int numberOfShips) {
        int length = gridDimension / 2;
        int width = 2;
        for (int i = 0; i < numberOfShips; i++) {
            if (i == numberOfShips / 2) {
                width--;
                length = (gridDimension / 2) - 1;
            }
            allShips.add(new Ship(i + 1, length, width, owner));
            length--;
        }
    }

    public void putTheShipsOnBoardRandomly() {

    }
}
