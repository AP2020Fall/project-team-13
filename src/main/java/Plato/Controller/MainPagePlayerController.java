package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Game;
import Plato.Model.Player;

public class MainPagePlayerController {
    private static MainPagePlayerController mainPagePlayerController = new MainPagePlayerController();

    public static MainPagePlayerController getInstance() {
        return mainPagePlayerController;
    }

    public String showPointController(){
        Player player = (Player) LoginPageController.user;
        int score = player.getScore();
        return String.valueOf(score);
    }

    public String viewFavoriteGames() {
        Player player = (Player) LoginPageController.user;
        String favorites = null;
        try {
            for (Game favorite : player.getFavorites()) {
                favorites=favorites+favorite.getName();
                favorites=favorites+"\n";
            }
            if (favorites.equals(null))
            {
                return "nothing found";
            }
            return favorites;
        } catch (Exception e) {
           return "nothing found";
        }

    }

    public String platobotMessages() {
        String messages = null;
        try {
            for (int i=0;i<Admin.getMessages().size();i++) {
                messages=messages+Admin.getMessages().get(i);
                messages=messages+"\n";
            }
            if (messages.equals(null))
            {
                messages="nothing found";
            }
            return messages;
        } catch (Exception e) {
            return "nothing found";
        }

    }

    public String viewSuggestions() {
        Player player = (Player) LoginPageController.user;
        String suggests = null;
        try {
            for (Game suggestedGame : player.getSuggestedGames()) {
                suggests=suggests+suggestedGame.getName();
                suggests=suggests+" ";
                suggests=suggests+suggestedGame.getGameID();
                suggests=suggests+"\n";
            }
            if (!suggests.equals(null)){
                return suggests;
            }
        } catch (Exception e) {
            return "nothing found";
        }
        return "nothing found";

    }

    public String viewLastPlayed() {
        Player player = (Player) LoginPageController.user;
        if (player.getGameHistory().size()>0)
        {
            return player.getGameHistory().get(player.getGameHistory().size()-1);
        }
        else {
            return "nothing found";
        }
    }

    public boolean issuggestedGameVAlid(int id) {
        Player player = (Player) LoginPageController.user;
        try {
            for (Game suggestedGame : player.getSuggestedGames()) {
                if (suggestedGame.getGameID()==id){
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public void addFriend(String username) {
        Player player1 = (Player) LoginPageController.user;
        for (Player player : Player.getPlayers()) {
            if (player.getUsername().equals(username)){
                player.getFriendRequests().add(player1);
            }
        }
    }

}
