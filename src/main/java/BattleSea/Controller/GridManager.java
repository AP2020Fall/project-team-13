package BattleSea.Controller;

import BattleSea.Model.Grid;
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

    public boolean bombLocation(int xAxis, int yAxis, Player bomber) {
        if (bomber.equals(owner)) {
            return opponentGrid.getLocation(xAxis, yAxis).Bomb();
        }
        else {
            playerGrid.getLocation(xAxis,yAxis).Bomb();
            return playerGrid.getLocation(xAxis, yAxis).isOccupied();
        }
    }

    public boolean occupyLocationByShip(int shipCode, int xAxis, int yAxis) {
        return playerGrid.getLocation(xAxis,yAxis).Occupy(shipCode);
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
