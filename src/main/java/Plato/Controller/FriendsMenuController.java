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
        String friends = null;
        try {
            for (Player friend : player.getFriends()) {
                friends=friends+friend.getUsername();
                friends=friends+" ";
                friends=friends+friend.getUserID();
                friends=friends+" ";
            }
            if (friends.equals(null)) {

                return "nothing found";
            }
            else {
                return friends;
            }

        } catch (Exception e) {
            return "nothing found";
        }

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

    public void removeFriend(String username) {
        Player player = (Player) LoginPageController.user;
        for (Player friend : player.getFriends()) {
            if (friend.getUsername().equals(username))
            {
                player.getFriends().remove(friend);
                break;
            }
        }
    }

    public void addFriend(String username) {
        Player player = (Player) LoginPageController.user;
        for (Player player1 : Player.getPlayers()) {
            if (player1.getUsername().equals(username))
            {
                player1.getFriendRequests().add(player);
                break;
            }
        }
    }

    public String showFriendRequests() {
        Player player = (Player) LoginPageController.user;
        StringBuilder requests = new StringBuilder();
        for (Player friendRequest : player.getFriendRequests()) {
            requests.append(friendRequest.getUsername()+" "+friendRequest.getUserID()+" "+friendRequest.getScore()+" "+friendRequest.getMoney()+"\n");
        }
        return String.valueOf(requests);
    }

    public void acceptFrend(String username) {
        Player player = (Player) LoginPageController.user;
        for (Player friend : player.getFriendRequests()) {
            if (friend.getUsername().equals(username))
            {
                friend.getMessages().add("friend request accepted by : "+player.getUsername());
                friend.getMessagesShown().add(false);
                player.getFriends().add(friend);
                player.getFriendRequests().remove(friend);
                break;
            }
        }
    }

    public void declineFriend(String username) {
        Player player = (Player) LoginPageController.user;
        for (Player friend : player.getFriendRequests()) {
            if (friend.getUsername().equals(username))
            {
                friend.getMessages().add("friend request declined by : "+player.getUsername());
                friend.getMessagesShown().add(false);
                player.getFriendRequests().remove(friend);
                break;
            }
        }
    }

    public String showUnShownMessages() {
        String messages = "\n";
        Player player = (Player) LoginPageController.user;
        for (int i=0;i<player.getMessagesShown().size();i++)
        {
            if (player.getMessagesShown().get(i).equals(false))
            {
                messages=messages+player.getMessages().get(i);
                messages=messages+"\n";
            }
        }
        return messages;
    }
}
