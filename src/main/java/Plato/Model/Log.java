package Plato.Model;

import java.util.ArrayList;

public class Log {
    private static ArrayList<Log> logs = new ArrayList<Log>();
    private int gameID;
    private Player player1;
    private Player player2;
    private int logID;


    public Log( int gameID, Player player1,Player player2) {
        this.gameID = gameID;
        this.player1 = player1;
        this.player2 = player2;
        this.logID = logs.size()+1;
    }



    public int getGameID() {
        return gameID;
    }

    public static ArrayList<Log> getLogs() {
        return logs;
    }

    public int getLogID() {
        return logID;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
