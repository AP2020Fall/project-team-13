package Plato.Model;

import java.util.ArrayList;

public class Log {
    private static ArrayList<Log> logs = new ArrayList<Log>();
    private String gameName;
    private int gameID;
    private Player player;
    private int timesOfPlay;
    private int wins;
    private int logID;
    private int gotScored;

    public Log(String gameName, int gameID, Player player, int timesOfPlay, int wins, int logID, int gotScored) {
        this.gameName = gameName;
        this.gameID = gameID;
        this.player = player;
        this.timesOfPlay = timesOfPlay;
        this.wins = wins;
        this.logID = logID;
        this.gotScored = gotScored;
    }

    public String getGameName() {
        return gameName;
    }

    public int getGameID() {
        return gameID;
    }

    public static ArrayList<Log> getLogs() {
        return logs;
    }

    public Player getPlayer() {
        return player;
    }

    public int getTimesOfPlay() {
        return timesOfPlay;
    }

    public int getWins() {
        return wins;
    }

    public int getLogID() {
        return logID;
    }

    public int getGotScored() {
        return gotScored;
    }

    public String showWins(int logID){
        return null;
    }

    public String showTimesOfPlay(int logID){
        return null;
    }
}
