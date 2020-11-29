package Plato.Controller;

import Plato.Model.Player;

public class FriendsMenuController {

    public String showFriendsController(){
        Player player = (Player) LoginPageController.user;
        player.getFriends();
        return null;
    }


}
