package BattleSea.Controller;

import BattleSea.Model.Coordination;
import BattleSea.Model.Grid;
import BattleSea.Model.Ship;
import Plato.Model.Player;

public class GridManager {
    private final Player owner;
    private Grid playerGrid;
    private Grid opponentGrid;
    private boolean bombingFlag;

    public GridManager(Player owner, int gridDimension) {
        this.owner = owner;
        playerGrid = new Grid(gridDimension, owner);
        opponentGrid = new Grid(gridDimension, owner);
    }

    public boolean bombLocation(int xAxis, int yAxis, Player bomber, ShipManager playerShipManager) {

        if (bomber.equals(owner)) {
            if(opponentGrid.getLocation(xAxis, yAxis).Bomb()){
                return true;
            } else return false;
        } else {
            playerGrid.getLocation(xAxis, yAxis).Bomb();
            if (playerGrid.getLocation(xAxis, yAxis).isOccupied()) {
                int shipCode = Integer.parseInt(playerGrid.getLocation(xAxis, yAxis).getContent());
                playerShipManager.getShipByShipCode(shipCode).makeItImmovable();
                playerGrid.getLocation(xAxis, yAxis).setContent("+");
                return true;
            } else {
                playerGrid.getLocation(xAxis, yAxis).setContent("-");
                playerGrid.getLocation(xAxis, yAxis).occupy();
                return false;
            }
        }
    }

    public void wasBombingLocationSuccessful(boolean answer,int xAxis, int yAxis){
        if (answer){
            opponentGrid.getLocation(xAxis,yAxis).setContent("+");
        } else opponentGrid.getLocation(xAxis,yAxis).setContent("-");
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
            if (playerGrid.getLocation(ship.getStartPoint().getXAxis() + xAxis, ship.getStartPoint().getYAxis() + yAxis).getContent().equals("" + ship.getCode())) {
                playerGrid.getLocation(ship.getStartPoint().getXAxis() + xAxis, ship.getStartPoint().getYAxis() + yAxis).setContent("r");
                return true;
            } else return false;
        } else {
            playerGrid.getLocation(ship.getStartPoint().getXAxis() + xAxis, ship.getStartPoint().getYAxis() + yAxis).setContent("r");
            return true;
        }

    }

    public void fixTheGrid() {
        for (Coordination[] coordinations : playerGrid.getTheGrid()) {
            for (Coordination coordination : coordinations) {
                if (coordination.getContent().equalsIgnoreCase("r")) coordination.rollbackContentChange();
            }
        }
    }

    private void moveShipToReservedLocation(Ship ship) {
        for (Coordination[] coordinations : playerGrid.getTheGrid()) {
            for (Coordination coordination : coordinations) {
                if (coordination.getContent().equalsIgnoreCase("" + ship.getCode())) {
                    coordination.setContent("");
                    coordination.unoccupy();
                }
                if (coordination.getContent().equalsIgnoreCase("r")) {
                    coordination.setContent(""+ship.getCode());
                    coordination.occupy();
                }

            }
        }
    }

    //public boolean putShipOnGrid(Ship ship){ }

    public Grid getPlayerGrid() {
        return playerGrid;
    }

    public Grid getOpponentGrid() {
        return opponentGrid;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isTheGridFullyBombed(){
        for (Coordination[] coordinations : opponentGrid.getTheGrid()) {
            for (Coordination coordination : coordinations) {
                if (!coordination.isBombed()) return false;
            }
        }
        return true;
    }

    public void destroyShip(int shipCode,Player destroyer){
        if (destroyer.equals(owner)){
            for (Coordination[] coordinations : opponentGrid.getTheGrid()) {
                for (Coordination coordination : coordinations) {
                    if (coordination.getContent().equalsIgnoreCase(""+shipCode))
                        coordination.setContent("*");
                }
            }
        }else{
            for (Coordination[] coordinations : playerGrid.getTheGrid()) {
                for (Coordination coordination : coordinations) {
                    if (coordination.getContent().equalsIgnoreCase(""+shipCode))
                        coordination.setContent("*");
                }
            }
        }
    }
}
