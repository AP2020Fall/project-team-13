package Plato.Model;

import org.json.simple.JSONArray;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Log {
    //fields
    private static ArrayList<Log> logs = new ArrayList<Log>();
    private int gameID;
    private Player player1;
    private Player player2;
    private Player winner;
    private LocalDate finishTime;

    //constructor
    public Log( int gameID, Player player1,Player player2, Player winner) {
        this.gameID = gameID;
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.finishTime = java.time.LocalDate.now();
    }

    //getter methods
    public int getGameID() {
        return gameID;
    }
    public static ArrayList<Log> getLogs() {
        return logs;
    }
    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public Player getWinner() {
        return winner;
    }
    public LocalDate getFinishTime() {
        return finishTime;
    }

    //add a log
    public static void addLog(int gameID, Player player1, Player player2, Player winner){
        Log log = new Log(gameID, player1, player2, winner);
        logs.add(log);
    }

    //overriding toString method
    @Override
    public String toString() {
        return
                "gameID=" + gameID +
                "\n player1=" + player1 +
                "\n player2=" + player2 +
                "\n winner=" + winner +
                "\n finishTime=" + finishTime
                ;
    }

    //update the logs that has been saved in file
    public static void updateLogs() throws FileNotFoundException {
        JSONArray ja = new JSONArray();
        int n = logs.size();
        for (int i = 0; i < n; i++) {
            Map m = new LinkedHashMap(5);
            m.put("gameID", logs.get(i).getGameID());
            m.put("player1", logs.get(i).getPlayer1().getUserID());
            m.put("player2", logs.get(i).getPlayer2().getUserID());
            m.put("winner", logs.get(i).getWinner().getUserID());
            m.put("finishTime", logs.get(i).getFinishTime());
            ja.add(m);
        }
        PrintWriter pw = new PrintWriter("logs.json");
        pw.write(ja.toJSONString());
        pw.flush();
        pw.close();
    }
}
