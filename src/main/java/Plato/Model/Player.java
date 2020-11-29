package Plato.Model;

import Plato.View.Page;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends User{
    private static ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Log> gamesLog = new ArrayList<Log>();
    private int daysPassedRegister;
    private int money;
    private int score;
    private ArrayList<Player> friends = new ArrayList<Player>();
    private ArrayList<String> requests = new ArrayList<String>();
    private ArrayList<Game> suggestedGames = new ArrayList<Game>();

    private Game playGame(int gameID){
        return null;

    }
    private void addFriend(int playerID){

    }


}
