package BattleSea.Controller;

import BattleSea.Model.Ship;
import Plato.Model.Player;

import java.util.ArrayList;

public class ShipManager {
    private ArrayList<Ship> allShips;
    private final Player owner;

    public ShipManager(Player owner, int gridDimension, int numberOfShips) {
        this.owner = owner;
        createShips(gridDimension, numberOfShips);

    }

    public boolean changeDirection(int shipCode) {
        return true;
    }

    public boolean changeLocation(int shipCode, int xDestination, int yDestination) {
        return true;
    }

    public ArrayList<Ship> getAllShips() {
        return allShips;
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
        putTheShipsOnBoard();
    }

    private void putTheShipsOnBoard(){
        
    }
}
