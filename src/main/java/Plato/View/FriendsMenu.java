package Plato.View;

import Plato.Controller.FriendsMenuController;

import java.util.regex.Matcher;

public class FriendsMenu extends Page{
    public static FriendsMenu friendsMenu = new FriendsMenu();
    private FriendsMenuController friendsMenuController = FriendsMenuController.getInstance();
    public Page run() {
        Matcher matcher;
        String input;
        while (true)
        {
            input=scanner.nextLine();
            friendsMenu.showUnShownMessages();
            if ((matcher = Commands.SHOW_FRIENDS.getMatcher(input)).matches())
            {
                friendsMenu.showFriends();
            }
            else if ((matcher = Commands.REMOVE_FRIENDS.getMatcher(input)).matches())
            {
                friendsMenu.removeFriend(matcher.group(1));
            }
            else if ((matcher = Commands.VIEW_USER_PROFILE_FRIEND_MENU.getMatcher(input)).matches())
            {
                friendsMenu.showPerson(matcher.group(1));
            }
            else if ((matcher = Commands.ADD_FRIEND.getMatcher(input)).matches())
            {
                friendsMenu.addFriend(matcher.group(1));
            }
            else if ((matcher = Commands.SHOW_FRIEND_REQUESTS.getMatcher(input)).matches())
            {
                friendsMenu.showFriendRequests();
            }
            else if ((matcher = Commands.ACCEPT_FRIEND_REQUEST.getMatcher(input)).matches())
            {
                friendsMenu.acceptFriend(matcher.group(1));
            }
            else if ((matcher = Commands.DECLNE_FRIEND_REQUEST.getMatcher(input)).matches())
            {
                friendsMenu.declineFriend(matcher.group(1));
            }
            else if ((matcher = Commands.HELP.getMatcher(input)).matches())
            {
                System.out.println("Show friends"+"\n"+"Remove\n"+"View user profile\n"+"Add\n"+"Show friend requests\n"+"Accept\n"
                        +"Decline\n");
            }
            else if (Commands.BACK.getMatcher(input).matches())
            {
                return seenPages.get(seenPages.size()-2);
            }
            else {
                System.out.println("invalid command");
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
    }
    private void acceptFriend(String username){
        friendsMenuController.acceptFrend(username);
    }
    private void declineFriend(String username){
        friendsMenuController.declineFriend(username);
    }
    private void showUnShownMessages()
    {
        String messages = friendsMenuController.showUnShownMessages();
    }

}
