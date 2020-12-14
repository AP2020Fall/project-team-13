package Plato.Controller;

import Plato.Model.Admin;
import Plato.Model.Game;
import Plato.Model.Log;
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
                favorites += favorite.getName() + "\n";
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
        String log;
        for (int i=Log.getLogs().size()-1; i>0;i--)
        {
            if (Log.getLogs().get(i).getPlayer1().equals(player)||Log.getLogs().get(i).getPlayer2().equals(player))
            {
                log = Log.getLogs().get(i).toString();
                return log;
            }

        }
        return "player didnt played yet";
    }

    public boolean isSuggestedGameValid(int id) {
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
