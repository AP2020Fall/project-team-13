package Plato.Model;

import java.util.ArrayList;

public class Log {
    private static ArrayList<Log> logs = new ArrayList<Log>();
    private Player player;
    private int timesOfPlay;
    private int wins;
    private int logID;
    private int gotScored;

    public Log(Player player) {
        this.player = player;
        this.gotScored=0;
        this.logID=logs.size()+1;
        this.timesOfPlay=0;
        this.wins=0;
    }
    public String showWins(int logID){
        return null;
    }
    public String showTimesOfPlay(int logID){
        return null;
    }
}
