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


    public String getPersonByName(String name) {
        ArrayList<Player> persons = Player.getPlayers();
        for (Player person : persons) {
            if (person.getUsername().equals(name))
            {
                String personInfo;
                personInfo=person.getFirstname()+" "+person.getLastname()+" "+person.getUserID()+" "+person.getUsername()+" "+" "+person.getEmail()+" "+"\n";
                personInfo=personInfo+person.getDaysPassedRegister()+" "+person.getScore()+" "+person.getMoney()+"\n";
                return personInfo;
            }
        }
        return "player not found";
    }
}
