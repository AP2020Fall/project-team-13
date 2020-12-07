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
                favorites=favorites+favorite.getName()+"\n";
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
                messages=messages+Admin.getMessages().get(i)+"\n";
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
}
