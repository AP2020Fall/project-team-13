package Plato.View;

import Plato.Controller.MainPagePlayerController;

import java.util.regex.Matcher;

public class MainPagePlayer extends Page{
    public static MainPagePlayer mainPagePlayer = new MainPagePlayer();
    private MainPagePlayerController mainPagePlayerController = MainPagePlayerController.getInstance();
    public Page run() {
        Matcher matcher;
        String input;
        while (true)
        {
            input=scanner.nextLine();
            if ((matcher = Commands.HELP.getMatcher(input)).matches())
            {
                System.out.println("Show Points"+"\n"+"View favorite games\n"+"View platobot’s messages\n"+"View last played\n"+"View admin’s suggestions\n"+"Choose suggested game\n"
                        +"Add friend\n");
            }
            else if  ((matcher = Commands.SHOW_POINT.getMatcher(input)).matches())
            {
                mainPagePlayer.showPoints();
            }
            else if ((matcher = Commands.VIEW_FAVORITE_GAMES.getMatcher(input)).matches())
            {
                mainPagePlayer.viewFavoriteGames();
            }
            else if ((matcher = Commands.VIEW_PLATOBOT_MESSAGES.getMatcher(input)).matches())
            {
                mainPagePlayer.platobotMessages();
            }
            else if ((matcher = Commands.VIEW_LAST_PLAYED.getMatcher(input)).matches())
            {
                mainPagePlayer.viewLastPlayed();
            }
            else if ((matcher = Commands.VIEW_ADMINS_SUGGESTIONS.getMatcher(input)).matches())
            {
                mainPagePlayer.adminSuggestions();
            }
            else if ((matcher = Commands.ADD_FRIEND.getMatcher(input)).matches())
            {
                mainPagePlayer.addFriend(matcher.group(1));
            }
            else if ((matcher = Commands.CHOOSE_SUGGESTED_GAME.getMatcher(input)).matches())
            {

                if (Integer.parseInt(matcher.group(1))==1)
                {
                    GameMenu.gameID=1;
                    return GameMenu.gameMenu;
                }
                else if (Integer.parseInt(matcher.group(1))==2)
                {
                    GameMenu.gameID=2;
                    return GameMenu.gameMenu;
                }
                else {
                    System.out.println("invalid gameID");
                }
            }
            else if ((matcher = Commands.BACK.getMatcher(input)).matches())
            {
                return seenPages.get(seenPages.size()-2);
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
    private void platobotMessages(){
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
    private boolean isGAmeVAlid(int id){
        boolean valid = mainPagePlayerController.issuggestedGameVAlid(id);
        return valid;
    }
    private void addFriend(String username){
        mainPagePlayerController.addFriend(username);
    }
}
