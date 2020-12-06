package BattleSea.Model;

import Plato.Model.Player;

public class Ship {
    private final Player owner;
    private final int code;
    private final int length;
    private final int width;
    private Coordination startPoint;
    private char direction;
    private boolean isDestroyed;

    public Ship(int code, int length, int width, Player owner) {
        this.code = code;
        this.length = length;
        this.width = width;
        this.owner = owner;
    }

    public void setStartPoint(Coordination startPoint) {
        this.startPoint = startPoint;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getCode() {
        return code;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Coordination getStartPoint() {
        return startPoint;
    }

    public char getDirection() {
        return direction;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void destroy() {
        isDestroyed = true;
    }
}
