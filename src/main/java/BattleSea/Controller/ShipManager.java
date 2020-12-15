package BattleSea.Controller;

import BattleSea.Model.Coordination;
import BattleSea.Model.Grid;
import BattleSea.Model.Ship;
import Plato.Model.Player;

import java.util.ArrayList;

public class ShipManager {
    private ArrayList<Ship> allShips;
    private final Player owner;

    public ShipManager(Player owner, int gridDimension, int numberOfShips) {
        this.owner = owner;
        allShips=new ArrayList<Ship>();
        createShips(gridDimension, numberOfShips);
    }

    public ArrayList<Ship> getAllShips() {
        return allShips;
    }

    public Ship getShipByShipCode(int shipCode) {
        return allShips.get(shipCode - 1);
    }

    public boolean isAnyShipDestroyed(GridManager playerGridManager) {
        for (Ship ship : allShips) {
            if (!ship.isDestroyed()) {
                boolean flag=true;
                for (Coordination[] line : getShipOnGrid(ship, playerGridManager)) {
                    for (Coordination coordination : line) {
                        if (!coordination.getContent().equals("+")) {
                            flag=false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
                if (flag){
                    ship.destroy();
                    return true;
                }
            }
        }
        return false;
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

    public Coordination[][] getShipOnGrid(Ship ship, GridManager gridManager) {
        Coordination[][] theShip;
        if (ship.getDirection() == 'n' || ship.getDirection() == 's') {
            theShip = new Coordination[ship.getLength()][ship.getWidth()];
            if (ship.getDirection() == 'n') {
                for (int i = ship.getLength() - 1; i >= 0; i--) {
                    for (int j = 0; j < ship.getWidth(); j++) {
                        theShip[i][j] = gridManager.getPlayerGrid().getLocation(
                                ship.getStartPoint().getXAxis() + (i - ship.getLength() + 1),
                                ship.getStartPoint().getYAxis() + (j));
                    }
                }
            } else {
                for (int i = 0; i < ship.getLength(); i++) {
                    for (int j = 0; j < ship.getWidth(); j++) {
                        theShip[i][j] = gridManager.getPlayerGrid().getLocation(
                                ship.getStartPoint().getXAxis() + (i),
                                ship.getStartPoint().getYAxis() + (j));
                    }
                }
            }
        } else {
            theShip = new Coordination[ship.getWidth()][ship.getLength()];
            if (ship.getDirection()=='w'){
                for (int j = ship.getLength() - 1; j >= 0; j--) {
                    for (int i = 0; i < ship.getWidth(); i++) {
                        theShip[i][j] = gridManager.getPlayerGrid().getLocation(
                                ship.getStartPoint().getXAxis() + (i),
                                ship.getStartPoint().getYAxis() + (j - ship.getLength() + 1));
                    }
                }
            } else {
                for (int j = 0; j < ship.getLength(); j++) {
                    for (int i = 0; i < ship.getWidth(); i++) {
                        theShip[i][j] = gridManager.getPlayerGrid().getLocation(
                                ship.getStartPoint().getXAxis() + (i),
                                ship.getStartPoint().getYAxis() + (j));
                    }
                }
            }
        }
        return theShip;
    }
}
