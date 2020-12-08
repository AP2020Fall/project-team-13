package BattleSea.Controller;

import BattleSea.Model.Coordination;
import BattleSea.Model.Grid;
import BattleSea.Model.Ship;
import Plato.Model.Player;

public class GridManager {
    private final Player owner;
    private Grid playerGrid;
    private Grid opponentGrid;

    public GridManager(Player owner, int gridDimension) {
        this.owner = owner;
        playerGrid = new Grid(gridDimension, owner);
        opponentGrid = new Grid(gridDimension, owner);
    }

    public boolean bombLocation(int xAxis, int yAxis, Player bomber, ShipManager playerShipManager) {
        if (bomber.equals(owner)) {
            return opponentGrid.getLocation(xAxis, yAxis).Bomb();
        } else {

            playerGrid.getLocation(xAxis, yAxis).Bomb();
            if (playerGrid.getLocation(xAxis, yAxis).isOccupied()) {
                opponentGrid.getLocation(xAxis, yAxis).setContent("+");
                int shipCode = Integer.parseInt(playerGrid.getLocation(xAxis, yAxis).getContent().split(" ")[1]);
                playerShipManager.getShipByShipCode(shipCode).isHit();
                return true;
            } else {
                opponentGrid.getLocation(xAxis, yAxis).setContent("-");
                return false;
            }
        }
    }

    public boolean changeLocationOfShip(Ship ship, int newStartPointXAxis, int newStartPointYAxis) throws IndexOutOfBoundsException {
        int changeInX = newStartPointXAxis - ship.getStartPoint().getXAxis();
        int changeInY = newStartPointYAxis - ship.getStartPoint().getYAxis();
        boolean flag = true;
        for (int i = 0; i < ship.getLength(); i++) {
            for (int j = 0; j < ship.getWidth(); j++) {
                if (ship.getDirection() == 'n') {
                    if (playerGrid.getLocation(newStartPointXAxis - i, newStartPointYAxis + j).isOccupied()) {
                        flag = false;
                    } else playerGrid.getLocation(newStartPointXAxis - i, newStartPointYAxis + j).setContent("reserve");
                } else if (ship.getDirection() == 's') {
                    if (playerGrid.getLocation(newStartPointXAxis + i, newStartPointYAxis + j).isOccupied()) {
                        flag = false;
                    } else playerGrid.getLocation(newStartPointXAxis + i, newStartPointYAxis + j).setContent("reserve");
                }
            }
        }
        for (int i = 0; i < ship.getWidth(); i++) {
            for (int j = 0; j < ship.getLength(); j++) {
                if (ship.getDirection() == 'w') {
                    if (playerGrid.getLocation(newStartPointXAxis + i, newStartPointYAxis - j).isOccupied()) {
                        flag = false;
                    } else playerGrid.getLocation(newStartPointXAxis + i, newStartPointYAxis - j).setContent("reserve");
                } else if (ship.getDirection() == 'e') {
                    if (playerGrid.getLocation(newStartPointXAxis + i, newStartPointYAxis + j).isOccupied()) {
                        flag = false;
                    } else playerGrid.getLocation(newStartPointXAxis + i, newStartPointYAxis + j).setContent("reserve");
                }
            }
        }
        if (flag) {
            for (Coordination[] coordinations : playerGrid.getTheGrid()) {
                for (Coordination coordination : coordinations) {
                    if (coordination.getContent().equalsIgnoreCase("ship " + ship.getCode()))
                        coordination.setContent("");
                    if (coordination.getContent().equalsIgnoreCase("reserve"))
                        coordination.setContent("ship " + ship.getCode());
                }
            }
        } else {
            for (Coordination[] coordinations : playerGrid.getTheGrid()) {
                for (Coordination coordination : coordinations) {
                    if (coordination.getContent().equalsIgnoreCase("reserve"))
                        coordination.setContent("");
                }
            }
        }
        return flag;
    }

    public Grid getPlayerGrid() {
        return playerGrid.getClone();
    }

    public Grid getOpponentGrid() {
        return opponentGrid.getClone();
    }

    public Player getOwner() {
        return owner;
    }
}
