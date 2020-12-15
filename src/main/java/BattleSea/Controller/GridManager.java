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
                playerShipManager.getShipByShipCode(shipCode).makeItImmovable();
                return true;
            } else {
                opponentGrid.getLocation(xAxis, yAxis).setContent("-");
                return false;
            }
        }
    }

    public boolean changeLocationOfShip(Ship ship, int newStartPointXAxis, int newStartPointYAxis) throws IndexOutOfBoundsException {
        boolean flag = true;
        int changeInX = newStartPointXAxis - ship.getStartPoint().getXAxis();
        int changeInY = newStartPointYAxis - ship.getStartPoint().getYAxis();
        if (ship.getDirection() == 'n' || ship.getDirection() == 's') {
            for (int i = 0; i < ship.getLength(); i++) {
                for (int j = 0; j < ship.getWidth(); j++) {
                    if (ship.getDirection() == 'n') {
                        if (!reserveLocation(ship, changeInX - i, changeInY + j)) flag = false;
                    } else {
                        if (!reserveLocation(ship, changeInX + i, changeInY + j)) flag = false;
                    }
                }
            }
        } else if (ship.getDirection() == 'w' || ship.getDirection() == 'e') {
            for (int i = 0; i < ship.getWidth(); i++) {
                for (int j = 0; j < ship.getLength(); j++) {
                    if (ship.getDirection() == 'w') {
                        if (!reserveLocation(ship, changeInX + i, changeInY - j)) flag = false;
                    } else {
                        if (!reserveLocation(ship, changeInX + i, changeInY + j)) flag = false;
                    }
                }
            }
        }
        if (flag) {
            moveShipToReservedLocation(ship);
            ship.setStartPoint(playerGrid.getLocation(newStartPointXAxis, newStartPointYAxis));
        } else {
            fixTheGrid();
        }
        return flag;
    }

    public boolean changeDirectionOfShip(Ship ship, char newDirection) throws IndexOutOfBoundsException {
        boolean flag = true;
        if (newDirection == 'n' || newDirection == 's') {
            for (int i = 0; i < ship.getLength(); i++) {
                for (int j = 0; j < ship.getWidth(); j++) {
                    if (newDirection == 'n') {
                        if (!reserveLocation(ship, -i, +j)) flag = false;
                    } else {
                        if (!reserveLocation(ship, +i, +j)) flag = false;
                    }
                }
            }
        } else if (newDirection == 'w' || newDirection == 'e') {
            for (int i = 0; i < ship.getWidth(); i++) {
                for (int j = 0; j < ship.getLength(); j++) {
                    if (newDirection == 'w') {
                        if (!reserveLocation(ship, +i, -j)) flag = false;
                    } else {
                        if (!reserveLocation(ship, +i, +j)) flag = false;
                    }
                }
            }
        }

        if (flag) {
            moveShipToReservedLocation(ship);
            ship.setDirection(newDirection);
        } else {
            fixTheGrid();
        }
        return flag;
    }

    private boolean reserveLocation(Ship ship, int xAxis, int yAxis) {
        if (playerGrid.getLocation(ship.getStartPoint().getXAxis() + xAxis, ship.getStartPoint().getYAxis() + yAxis).isOccupied()) {
            if (playerGrid.getLocation(ship.getStartPoint().getXAxis() + xAxis, ship.getStartPoint().getYAxis() + yAxis).getContent().equalsIgnoreCase("ship " + ship.getCode())) {
                playerGrid.getLocation(ship.getStartPoint().getXAxis() + xAxis, ship.getStartPoint().getYAxis() + yAxis).setContent("reserve");
                return true;
            } else return false;
        } else {
            playerGrid.getLocation(ship.getStartPoint().getXAxis() + xAxis, ship.getStartPoint().getYAxis() + yAxis).setContent("reserve");
            return true;
        }

    }

    public void fixTheGrid() {
        for (Coordination[] coordinations : playerGrid.getTheGrid()) {
            for (Coordination coordination : coordinations) {
                if (coordination.getContent().equalsIgnoreCase("reserve")) coordination.rollbackContentChange();
            }
        }
    }

    private void moveShipToReservedLocation(Ship ship) {
        for (Coordination[] coordinations : playerGrid.getTheGrid()) {
            for (Coordination coordination : coordinations) {
                if (coordination.getContent().equalsIgnoreCase("ship " + ship.getCode())) {
                    coordination.setContent("");
                    coordination.unoccupy();
                }
                if (coordination.getContent().equalsIgnoreCase("reserve")) {
                    coordination.setContent("ship " + ship.getCode());
                    coordination.occupy();
                }

            }
        }
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
