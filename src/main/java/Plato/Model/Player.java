package Plato.Model;

import java.util.ArrayList;

public class Player extends User{
    private static ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Log> gamesLog = new ArrayList<Log>();
    private int daysPassedRegister;
    private int money;
    private int score;
    private ArrayList<Player> friends = new ArrayList<Player>();
    private ArrayList<String> requests = new ArrayList<String>();
    private ArrayList<Game> suggestedGames = new ArrayList<Game>();

    public Game playGame(int gameID){
        return null;

    }
    public void addFriend(int playerID){

    }
    public static void registerModel(){

    }
    public Log getLog(int gameId){

        return null;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Log> getGamesLog() {
        return gamesLog;
    }

    public int getDaysPassedRegister() {
        return daysPassedRegister;
    }

    public int getMoney() {
        return money;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Player> getFriends() {
        return friends;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

    public ArrayList<Game> getSuggestedGames() {
        return suggestedGames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return this.getUsername().equals(player.getUsername());
    }

}
