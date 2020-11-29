package BattleSea.Model;

import Plato.Model.Player;

public class Grid {
    private final int xDimension;
    private final int yDimension;
    private Coordination[][] theGrid;
    private final Player owner;

    public Grid(int xDimension, int yDimension, Player owner) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
        theGrid=new Coordination[xDimension][yDimension];
        for (int i = 0; i < xDimension; i++) {
            for (int j = 0; j < yDimension; j++) {
                theGrid[i][j]=new Coordination(i+1,j+1);
            }
        }
        this.owner = owner;
    }

    public int getXDimension() {
        return xDimension;
    }

    public int getYDimension() {
        return yDimension;
    }

    public Player getOwner() {
        return owner;
    }

    public Coordination getLocation(int xAxis,int yAxis){
        return theGrid[xAxis-1][yAxis-1];
    }
}
