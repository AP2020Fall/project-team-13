package BattleSea.Model;

import Plato.Model.Player;

public class Grid {
    private final int dimension;
    private Coordination[][] theGrid;
    private final Player owner;

    public Grid(int dimension, Player owner) {
        this.dimension = dimension;
        theGrid = new Coordination[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                theGrid[i][j] = new Coordination(i + 1, j + 1);
            }
        }
        this.owner = owner;
    }

    public int getDimension() {
        return dimension;
    }

    public Coordination[][] getTheGrid() {
        return theGrid;
    }

    public Coordination getLocation(int xAxis, int yAxis) {
        return theGrid[xAxis - 1][yAxis - 1];
    }

}


