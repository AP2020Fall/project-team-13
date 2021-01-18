package Plato.View;

import Plato.Controller.MainPagePlayerController;
import Plato.Model.*;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;

public class MainPagePlayer extends Page{
    public static MainPagePlayer mainPagePlayer = new MainPagePlayer();
    private MainPagePlayerController mainPagePlayerController = MainPagePlayerController.getInstance();
    public Page run() throws FileNotFoundException {
        Matcher matcher;
        String input;
        seenPages.add(MainPagePlayer.mainPagePlayer);
        System.out.println("Main.Main Page Player :");
        while (true) {
            Admin.updateAdmins();
            Player.updatePlayers();
            Game.updateGames();
            Log.updateLogs();
            Event.updateEvents();
            input=scanner.nextLine();
            if ((matcher = Commands.HELP.getMatcher(input)).matches()) {
                System.out.println("Show Points"+"\n"+"View favorite games\n"+"View platoBot’s messages\n"+"View last played\n"+"View admin’s suggestions\n"+"Choose suggested game\n"
                        +"choose favorite (1,2)"+"Add friend\n"+"go to friends menu\n"+"go to games menu\n"+"view events\n"+"join event\n"
                +"back");
            }
            else if  ((matcher = Commands.SHOW_POINT.getMatcher(input)).matches()) {
                mainPagePlayer.showPoints();
            }
            else if ((matcher = Commands.VIEW_FAVORITE_GAMES.getMatcher(input)).matches()) {
                mainPagePlayer.viewFavoriteGames();
            }
            else if ((matcher = Commands.VIEW_PLATOBOT_MESSAGES.getMatcher(input)).matches()) {
                mainPagePlayer.platoBotMessages();
            }
            else if ((matcher = Commands.VIEW_LAST_PLAYED.getMatcher(input)).matches()) {
                mainPagePlayer.viewLastPlayed();
            }
            else if ((matcher = Commands.VIEW_ADMINS_SUGGESTIONS.getMatcher(input)).matches()) {
                mainPagePlayer.adminSuggestions();
            }
            else if ((matcher = Commands.ADD_FRIEND.getMatcher(input)).matches()) {
                mainPagePlayer.addFriend(matcher.group(1));
            }
            else if ((matcher = Commands.CHOOSE_SUGGESTED_GAME.getMatcher(input)).matches()) {

                if (Integer.parseInt(matcher.group(1))==1)
                {
                    ReversiMenu game = new ReversiMenu();
                    return game;
                }
                else if (Integer.parseInt(matcher.group(1))==2)
                {
                    BattleSeaMenu game = new BattleSeaMenu();
                    return game;
                }
                else {
                    System.out.println("invalid gameID");
                }
            }
            else if ((matcher = Commands.BACK.getMatcher(input)).matches()) {
                return seenPages.get(seenPages.size()-2);
            }
            else if ((matcher = Commands.CHOOSE_FAVORITE_GAME.getMatcher(input)).matches()) {

                if (Integer.parseInt(matcher.group(1))==1)
                {
                    return ReversiMenu.reversiMenu;
                }
                else if (Integer.parseInt(matcher.group(1))==2)
                {
                    return BattleSeaMenu.battleSeaMenu;
                }
            }
            else if ((matcher = Commands.VIEW_EVENTS.getMatcher(input)).matches()) {
                MainPageAdmin.mainPageAdmin.viewEvents();
            }
            else if ((matcher = Commands.JOIN_EVENT.getMatcher(input)).matches()) {
                MainPagePlayer.mainPagePlayer.joinEvent(Integer.parseInt(matcher.group(1)));
            }
            else if ((matcher = Commands.GO_TO_FRIENDS_MENU.getMatcher(input)).matches()) {
                return FriendsMenu.friendsMenu;
            }
            else if ((matcher = Commands.GO_TO_GAMES_MENU.getMatcher(input)).matches()) {
                return GamesMenu.gamesMenu;
            }
            else if(input.trim().equals("logout")){
                return LoginPage.loginPage;
            }
            else {
                System.out.println("invalid command");
            }
        }

    }
    private void showPoints(){
        String point;
        point=mainPagePlayerController.showPointController();
        System.out.println(point);

    }
    private void viewFavoriteGames(){
        String favorites;
        favorites=mainPagePlayerController.viewFavoriteGames();
        System.out.println(favorites);
    }
    private void platoBotMessages(){
        String messages;
        messages=mainPagePlayerController.platobotMessages();
        System.out.println(messages);
    }
    private void adminSuggestions(){
        String suggests=mainPagePlayerController.viewSuggestions();
        System.out.println(suggests);
    }
    private void viewLastPlayed(){
        String lastPlayed;
        lastPlayed=mainPagePlayerController.viewLastPlayed();
        System.out.println(lastPlayed);
    }
    private boolean isGameValid(int id){
        boolean valid = mainPagePlayerController.isSuggestedGameValid(id);
        return valid;
    }
    private void addFriend(String username){
        mainPagePlayerController.addFriend(username);
    }
    private void joinEvent(int id)
    {
        mainPagePlayerController.joinEvent(id);
    }
}
