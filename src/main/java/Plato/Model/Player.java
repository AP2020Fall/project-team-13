package Plato.Model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Player extends User{
    //fields
    private static ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Log> gamesLog = new ArrayList<Log>();
    private LocalDate registerTime;
    private int money = 0;
    private int score = 0;
    private int reversiWins = 0;
    private int reversiDraws = 0;
    private int reversiLosses = 0;
    private int reversiPlayedCount = 0;
    private int reversiPoints = 0;
    private int battleSeaWins = 0;
    private int battleSeaDraws = 0;
    private int battleSeaLosses = 0;
    private int battleSeaPlayedCount = 0;
    private int battleSeaPoints = 0;
    private ArrayList<Player> friends = new ArrayList<Player>();
    private ArrayList<Player> friendRequests = new ArrayList<Player>();
    private ArrayList<Game> suggestedGames = new ArrayList<Game>();
    private ArrayList<Integer> suggestionID = new ArrayList<Integer>();
    private ArrayList<Game> favorites = new ArrayList<Game>();
    private ArrayList<String> gameHistory = new ArrayList<String>();
    private ArrayList<String> messages = new ArrayList<String>();
    private ArrayList<Boolean> messagesShown = new ArrayList<Boolean>();

    //constructor
    public Player(){
        this.registerTime = java.time.LocalDate.now();
    }

    public static void deletePlayerAccount(int ID){
        for (Player player : players) {
            if (player.getUserID()==ID) {
                players.remove(player);
                break;
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
    public ArrayList<String> getGameHistory() {
        return gameHistory;
    }
    public LocalDate getRegister() {
        return registerTime;
    }
    public ArrayList<String> getMessages() {
        return messages;
    }
    public ArrayList<Boolean> getMessagesShown() {
        return messagesShown;
    }
    public void addFavorite(int id){
        if (id==1)
        {
            for (Game game : Game.getGames()) {
                if (game.getGameID()==id)
                {
                    if(!this.getFavorites().contains(game))
                        this.getFavorites().add(game);
                }
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
    public void addBattleSeaPoints(){
        this.battleSeaPoints++;
    }
    public int getBattleSeaPoints() {
        return battleSeaPoints;
    }
    public String getDaysPassedRegister() {

        return null;
    }
    public Game playGame(int gameID){
        return null;

    }
    public void addFriend(int playerID){

    }
    public static void registerModel(){

    }
    public static ArrayList<Player> getPlayers() {
        return players;
    }
    public ArrayList<Log> getGamesLog() {
        return gamesLog;
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
}
