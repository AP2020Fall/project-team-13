package BattleSea.Model;

import Plato.Model.Player;

public class Ship {
    private final Player owner;
    private final int code;
    private final int length;
    private final int width;
    private Coordination startPoint;
    private String direction;

    public Ship(int code, int length, int width, Player owner) {
        this.code = code;
        this.length = length;
        this.width = width;
        this.owner = owner;
    }

    public void setStartPoint(Coordination startPoint) {
        this.startPoint = startPoint;
    }

    public void setDirection(String direction) {
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

    public String getDirection() {
        return direction;
    }

    public Player getOwner() {
        return owner;
    }
}
