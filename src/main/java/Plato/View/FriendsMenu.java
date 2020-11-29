package Plato.View;

import Plato.Controller.FriendsMenuController;

public class FriendsMenu extends Page{
    FriendsMenuController friendsMenuController;
    Page run() {
        friendsMenuController.showFriendsController();
        return null;
    }


}
