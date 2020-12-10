package Plato.Model;

import Plato.View.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Player extends User{
    private static ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Log> gamesLog = new ArrayList<Log>();
    private int daysPassedRegister;
    private Date register = new Date();
    private int money;
    private int score;
    private int reversiWins = 0;
    private int reversiPlayedCount = 0;
    private ArrayList<Player> friends = new ArrayList<Player>();
    private ArrayList<Player> friendRequests = new ArrayList<Player>();
    private ArrayList<Game> suggestedGames = new ArrayList<Game>();
    private ArrayList<Integer> suggestionID = new ArrayList<Integer>();
    private ArrayList<Game> favorites = new ArrayList<Game>();
    private ArrayList<String> gameHistory = new ArrayList<String>();
    private ArrayList<String> messages = new ArrayList<String>();
    private ArrayList<Boolean> messagesShown = new ArrayList<Boolean>();
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

    public ArrayList<Player> getFriendRequests() {
        return friendRequests;
    }

    public ArrayList<Game> getSuggestedGames() {
        return suggestedGames;
    }

    public static Player getPlayerByID(int id){
        for (Player player : players) {
            if (player.getUserID()==id){
                return player;
            }

        }
        return null;
    }

    public static void deletePlayerAccount(int ID){
        for (Player player : players) {
            if (player.getUserID()==ID)
            {
                players.remove(player);
                for (Log log : Log.getLogs()) {
                    if (log.getPlayer().equals(player))
                    {
                        Log.getLogs().remove(log);
                    }
                }
                break;
            }
        }
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

    public ArrayList<Integer> getSuggestionID() {
        return suggestionID;
    }

    public ArrayList<Game> getFavorites() {
        return favorites;
    }

    public void addScore(){
        this.score += 1;
    }

    public ArrayList<String> getGameHistory() {
        return gameHistory;
    }

    public Date getRegister() {
        return register;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public ArrayList<Boolean> getMessagesShown() {
        return messagesShown;
    }

    public void addFavorite(Game game){
        if(!this.getFavorites().contains(game))
            this.getFavorites().add(game);
    }

    public void addReversiWins(){
        this.reversiWins++;
    }

    public int getReversiWins() {
        return reversiWins;
    }

    public void addReversiPlayedCount(){
        this.reversiPlayedCount++;
    }

    public int getReversiPlayedCount() {
        return reversiPlayedCount;
    }

    public Player(Date register, int score, int reversiWins, int reversiPlayedCount) {
        this.register = register;
        this.score = score;
        this.reversiWins = reversiWins;
        this.reversiPlayedCount = reversiPlayedCount;
    }
}
