package Plato.Model;


import org.json.simple.JSONArray;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Player extends User{
    //fields
    private static ArrayList<Player> players = new ArrayList<Player>();
    private LocalDate registerTime;
    private int money;
    private int score;
    private int reversiWins;
    private int reversiDraws;
    private int reversiLosses;
    private int reversiPlayedCount;
    private int reversiPoints;
    private int battleSeaWins;
    private int battleSeaDraws;
    private int battleSeaLosses;
    private int battleSeaPlayedCount;
    private int battleSeaPoints;
    private ArrayList<Player> friends = new ArrayList<Player>();
    private ArrayList<Player> friendRequests = new ArrayList<Player>();
    private ArrayList<Game> suggestedGames = new ArrayList<Game>();
    private ArrayList<Integer> suggestionID = new ArrayList<Integer>();
    private ArrayList<Game> favorites = new ArrayList<Game>();
    private ArrayList<String> messages = new ArrayList<String>();
    private ArrayList<Boolean> messagesShown = new ArrayList<Boolean>();

    //constructor
    public Player() {
        this.money = 0;
        this.score = 0;
        this.reversiWins = 0;
        this.reversiDraws = 0;
        this.reversiLosses = 0;
        this.reversiPlayedCount = 0;
        this.reversiPoints = 0;
        this.battleSeaWins = 0;
        this.battleSeaDraws = 0;
        this.battleSeaLosses = 0;
        this.battleSeaPlayedCount = 0;
        this.battleSeaPoints = 0;
        this.registerTime = java.time.LocalDate.now();
    }

    //remove the player from the list of players
    public static void deletePlayerAccount(int ID){
        for (Player player : players) {
            if (player.getUserID()==ID) {
                players.remove(player);
                return;
            }

        }
    }

    //overriding equals method for Player class
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return this.getUsername().equals(player.getUsername());
    }

    //adder and getter methods
    public ArrayList<Integer> getSuggestionID() {
        return suggestionID;
    }
    public ArrayList<Game> getFavorites() {
        return favorites;
    }
    public void addScore(){
        this.score += 1;
    }
    public LocalDate getRegisterTime() {
        return registerTime;
    }
    public ArrayList<String> getMessages() {
        return messages;
    }
    public ArrayList<Boolean> getMessagesShown() {
        return messagesShown;
    }
    public void addFavorite(int id){
        for (Game game : Game.getGames()){
            if (game.getGameID()==id){
                if(!this.getFavorites().contains(game))
                    this.getFavorites().add(game);
            }
        }

    }
    public void addReversiWins(){
        this.reversiWins++;
    }
    public int getReversiWins() {
        return reversiWins;
    }
    public void addReversiDraws(){
        this.reversiDraws++;
    }
    public int getReversiDraws() {
        return reversiDraws;
    }
    public void addReversiLosses(){
        this.reversiLosses++;
    }
    public int getReversiLosses() {
        return reversiLosses;
    }
    public void addReversiPlayedCount(){
        this.reversiPlayedCount++;
    }
    public int getReversiPlayedCount() {
        return reversiPlayedCount;
    }
    public void addReversiPoints(){
        this.reversiPoints++;
    }
    public int getReversiPoints() {
        return reversiPoints;
    }
    public void addBattleSeaWins(){
        this.battleSeaWins++;
    }
    public int getBattleSeaWins() {
        return battleSeaWins;
    }
    public void addBattleSeaDraws(){
        this.battleSeaDraws++;
    }
    public int getBattleSeaDraws() {
        return battleSeaDraws;
    }
    public void addBattleSeaLosses(){
        this.battleSeaLosses++;
    }
    public int getBattleSeaLosses(){
        return battleSeaLosses;
    }
    public void addBattleSeaPlayedCount(){
        this.battleSeaPlayedCount++;
    }
    public int getBattleSeaPlayedCount() {
        return battleSeaPlayedCount;
    }
    public void addBattleSeaPoints(int point){
        this.battleSeaPoints += point;
    }
    public int getBattleSeaPoints() {
        return battleSeaPoints;
    }
    public int getDaysPassedRegister() {
        LocalDate now = java.time.LocalDate.now();
        return ( (getRegisterTime().getYear() - now.getYear()) * 365 + (getRegisterTime().getDayOfYear() - now.getDayOfYear()) );
    }
    public static ArrayList<Player> getPlayers() {
        return players;
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

    //return the player with id entered
    public static Player getPlayerByID(int id){
        for (Player player : players) {
            if (player.getUserID()==id){
                return player;
            }

        }
        return null;
    }

    //sort for ReversiMenu
    public static ArrayList<Player> sortForReversiMenu(ArrayList<Player> players){
        int n = players.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                if (players.get(j).getReversiPoints() > players.get(j + 1).getReversiPoints()) {
                    players.add(j, players.get(j + 1));
                    players.remove(j + 2);
                } else if (players.get(j).getReversiPoints() == players.get(j + 1).getReversiPoints()) {
                    if(players.get(j).getReversiWins() > players.get(j + 1).getReversiWins()){
                        players.add(j, players.get(j + 1));
                        players.remove(j + 2);
                    }
                    else if(players.get(j).getReversiWins() == players.get(j + 1).getReversiWins()){
                        if(players.get(j).getReversiDraws() > players.get(j + 1).getReversiDraws()){
                            players.add(j, players.get(j + 1));
                            players.remove(j + 2);
                        }
                        else if(players.get(j).getReversiDraws() == players.get(j + 1).getReversiDraws()){
                            if(players.get(j).getReversiLosses() < players.get(j + 1).getReversiLosses()){
                                players.add(j, players.get(j + 1));
                                players.remove(j + 2);
                            }
                            else if(players.get(j).getReversiLosses() == players.get(j + 1).getReversiLosses()){
                                if(players.get(j).getUsername().compareToIgnoreCase(players.get(j + 1).getUsername()) < 0){
                                    players.add(j, players.get(j + 1));
                                    players.remove(j + 2);
                                }
                            }
                        }
                    }
                }
            }
        return players;
    }

    //sort for BattleSeaMenu
    public static ArrayList<Player> sortForBattleSeaMenu(ArrayList<Player> players){
        int n = players.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                if (players.get(j).getBattleSeaPoints() > players.get(j + 1).getBattleSeaPoints()) {
                    players.add(j, players.get(j + 1));
                    players.remove(j + 2);
                }
                else if (players.get(j).getBattleSeaPoints() == players.get(j + 1).getBattleSeaPoints()) {
                    if(players.get(j).getBattleSeaWins() > players.get(j + 1).getBattleSeaWins()){
                        players.add(j, players.get(j + 1));
                        players.remove(j + 2);
                    }
                    else if(players.get(j).getBattleSeaWins() == players.get(j + 1).getBattleSeaWins()){
                        if(players.get(j).getBattleSeaDraws() > players.get(j + 1).getBattleSeaDraws()){
                            players.add(j, players.get(j + 1));
                            players.remove(j + 2);
                        }
                        else if(players.get(j).getBattleSeaDraws() == players.get(j + 1).getBattleSeaDraws()){
                            if(players.get(j).getBattleSeaLosses() < players.get(j + 1).getBattleSeaLosses()){
                                players.add(j, players.get(j + 1));
                                players.remove(j + 2);
                            }
                            else if(players.get(j).getBattleSeaLosses() == players.get(j + 1).getBattleSeaLosses()){
                                if(players.get(j).getUsername().compareToIgnoreCase(players.get(j + 1).getUsername()) < 0){
                                    players.add(j, players.get(j + 1));
                                    players.remove(j + 2);
                                }
                            }
                        }
                    }
                }
            }
        return players;
    }

    //returning the level of battle sea
    public int getBattleSeaLevel(){
        return (this.battleSeaPoints / 10);
    }

    //returning the level of reversi
    public int getReversiLevel(){
        return (this.reversiPoints / 10);
    }

    //edit information
    @Override
    public void editInformation(String type, String newValue) {
        super.editInformation(type, newValue);
    }

    //update the players that has been saved in file
    public static void updatePlayers() throws FileNotFoundException {
        JSONArray ja = new JSONArray();
        int n = players.size();
        for (int i = 0; i < n; i++) {
            Map m = new LinkedHashMap(28);
            m.put("firstname", players.get(i).getFirstname());
            m.put("lastname", players.get(i).getLastname());
            m.put("username", players.get(i).getUsername());
            m.put("userID", players.get(i).getUserID());
            m.put("password", players.get(i).getPassword());
            m.put("email", players.get(i).getEmail());
            m.put("phoneNumber", players.get(i).getPhoneNumber());
            m.put("isAdmin", players.get(i).isAdmin());
            m.put("registerTime", players.get(i).getRegisterTime());
            m.put("money", players.get(i).getMoney());
            m.put("score", players.get(i).getScore());
            m.put("reversiWins", players.get(i).getReversiWins());
            m.put("reversiDraws", players.get(i).getReversiDraws());
            m.put("reversiLosses", players.get(i).getReversiLosses());
            m.put("reversiPlayedCount", players.get(i).getReversiPlayedCount());
            m.put("reversiPoints", players.get(i).getReversiPoints());
            m.put("battleSeaWins", players.get(i).getBattleSeaWins());
            m.put("battleSeaDraws", players.get(i).getBattleSeaDraws());
            m.put("battleSeaLosses", players.get(i).getBattleSeaLosses());
            m.put("battleSeaPlayedCount", players.get(i).getBattleSeaPlayedCount());
            m.put("battleSeaPoints", players.get(i).getBattleSeaPoints());
            int t = players.get(i).getFriends().size();
            ArrayList<String> friends = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                friends.add(players.get(i).getFriends().get(j).getUsername());
            }
            m.put("friends", friends);
            t = players.get(i).getFriendRequests().size();
            ArrayList<String> friendRequests = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                friendRequests.add(players.get(i).getFriendRequests().get(j).getUsername());
            }
            m.put("friendRequests", friendRequests);
            t = players.get(i).getSuggestedGames().size();
            ArrayList<Integer> suggestedGames = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                suggestedGames.add(players.get(i).getSuggestedGames().get(j).getGameID());
            }
            m.put("suggestedGames", suggestedGames);
            t = players.get(i).getSuggestionID().size();
            ArrayList<Integer> suggestionID = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                suggestedGames.add(players.get(i).getSuggestionID().get(j));
            }
            m.put("suggestionID", suggestionID);
            t = players.get(i).getFavorites().size();
            ArrayList<Integer> favorites = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                suggestedGames.add(players.get(i).getFavorites().get(j).getGameID());
            }
            m.put("favorites", favorites);
            t = players.get(i).getMessages().size();
            ArrayList<String> messages = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                messages.add(players.get(i).getMessages().get(j));
            }
            m.put("messages", messages);
            t = players.get(i).getMessages().size();
            ArrayList<Boolean> messagesShown = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                messagesShown.add(players.get(i).getMessagesShown().get(j));
            }
            m.put("messagesShown", messagesShown);
            ja.add(m);
        }
        PrintWriter pw = new PrintWriter("players.json");
        pw.write(ja.toJSONString());
        pw.flush();
        pw.close();
    }
}
