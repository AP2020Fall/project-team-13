package Plato.View;

import Plato.Controller.FriendsMenuController;

public class FriendsMenu extends Page{
    private static FriendsMenu friendsMenu = new FriendsMenu();
    private FriendsMenuController friendsMenuController = FriendsMenuController.getInstance();
    public Page run() {
        friendsMenuController.showFriendsController();
        return null;
    }

    private void showPerson(String name){
        String person;
        person = friendsMenuController.getPersonByName(name);
        System.out.println(person);
    }


}
