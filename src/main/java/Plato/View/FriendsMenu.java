package Plato.View;

import Plato.Controller.FriendsMenuController;
import Plato.Model.*;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;

public class FriendsMenu extends Page{
    public static FriendsMenu friendsMenu = new FriendsMenu();
    private FriendsMenuController friendsMenuController = FriendsMenuController.getInstance();
    public Page run() throws FileNotFoundException {
        Matcher matcher;
        String input;
        Page.seenPages.add(FriendsMenu.friendsMenu);
        System.out.println("Friends Menu :");
        while (true) {
            Admin.updateAdmins();
            Player.updatePlayers();
            Game.updateGames();
            Log.updateLogs();
            Event.updateEvents();
            input=scanner.nextLine();
            friendsMenu.showUnShownMessages();
            if ((matcher = Commands.SHOW_FRIENDS.getMatcher(input)).matches()) {
                friendsMenu.showFriends();
            }
            else if ((matcher = Commands.REMOVE_FRIENDS.getMatcher(input)).matches()) {
                friendsMenu.removeFriend(matcher.group(1));
            }
            else if ((matcher = Commands.VIEW_USER_PROFILE_FRIEND_MENU.getMatcher(input)).matches()) {
                friendsMenu.showPerson(matcher.group(1));
            }
            else if ((matcher = Commands.ADD_FRIEND.getMatcher(input)).matches()) {
                friendsMenu.addFriend(matcher.group(1));
            }
            else if ((matcher = Commands.SHOW_FRIEND_REQUESTS.getMatcher(input)).matches()) {
                friendsMenu.showFriendRequests();
            }
            else if ((matcher = Commands.ACCEPT_FRIEND_REQUEST.getMatcher(input)).matches()) {
                friendsMenu.acceptFriend(matcher.group(1));
            }
            else if ((matcher = Commands.DECLNE_FRIEND_REQUEST.getMatcher(input)).matches()) {
                friendsMenu.declineFriend(matcher.group(1));
            }
            else if ((matcher = Commands.HELP.getMatcher(input)).matches()) {
                System.out.println("show friends"+"\n"+"remove (username)\n"+"view user profile\n"+"Add (username)\n"+"Show friend requests\n"+"Accept (username)\n"
                        +"decline (username)\n"+"help\n"+"back\n"+"view account menu");
            }
            else if (Commands.BACK.getMatcher(input).matches()) {
                return seenPages.get(seenPages.size()-2);
            }
            else if ((matcher = Commands.VIEW_ACCOUNT_MENU.getMatcher(input)).matches()) {
                return UserPage.userPage;
            }
            else {
                System.out.println("invalid command!");
            }
        }
    }


    private void showFriends(){
        String friends = friendsMenuController.showFriendsController();
        System.out.println(friends);
    }
    private void removeFriend(String username)
    {
        friendsMenuController.removeFriend(username);
    }
    private void showPerson(String name){
        String person;
        person = friendsMenuController.getPersonByName(name);
        System.out.println(person);
    }
    private void addFriend(String username){
        friendsMenuController.addFriend(username);
    }
    private void showFriendRequests(){
        String requests = friendsMenuController.showFriendRequests();
        System.out.println(requests);
    }
    private void acceptFriend(String username){
        friendsMenuController.acceptFrend(username);
    }
    private void declineFriend(String username){
        friendsMenuController.declineFriend(username);
    }
    private void showUnShownMessages() {
        String messages = friendsMenuController.showUnShownMessages();
        System.out.println(messages);
    }

}
