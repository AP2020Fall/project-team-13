package Plato.Controller;

import Plato.Model.Player;

import java.util.ArrayList;

public class FriendsMenuController {
    private static FriendsMenuController friendsMenuController = new FriendsMenuController();

    public static FriendsMenuController getInstance() {
        return friendsMenuController;
    }

    public String showFriendsController(){
        Player player = (Player) LoginPageController.user;
        ArrayList<Player> friends =player.getFriends();
        return null;
    }


}
