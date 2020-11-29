package BattleSea.Controller;

import BattleSea.Model.Ship;
import Plato.Model.Player;

import java.util.ArrayList;

public class ShipManager {
    private ArrayList<Ship> allShips;
    private Player owner;

    public ShipManager(Player owner) {
        this.owner = owner;
    }

    public boolean changeDirection(int shipCode){
        return true;
    }
    public boolean changeLocation(int shipCode,int xDestination,int yDestination){
        return true;
    }
}
