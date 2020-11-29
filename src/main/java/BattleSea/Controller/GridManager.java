package BattleSea.Controller;

import BattleSea.Model.Grid;
import Plato.Model.Player;

public class GridManager {
    private Player owner;
    private Grid playerGrid;
    private Grid opponentGrid;

    public GridManager(Player owner, int gridXDimension, int gridYDimension) {
        this.owner = owner;
        playerGrid = new Grid(gridXDimension, gridYDimension, owner);
        opponentGrid = new Grid(gridXDimension, gridYDimension, owner);
    }

    public boolean bombLocation(int xAxis, int yAxis) {
        return true;
    }

    public boolean occupyLocationByShip(int shipCode, int xAxis, int yAxis) {
        return true;
    }

    public Grid getPlayerGrid() {
        return playerGrid;
    }

    public Grid getOpponentGrid() {
        return opponentGrid;
    }
}
