package Plato.Controller;

import Plato.Model.*;

import java.util.ArrayList;

public class MainPageAdminController {
    private static MainPageAdminController mainPageAdminController = new MainPageAdminController();

    public static MainPageAdminController getInstance() {
        return mainPageAdminController;
    }

    public void addNewAdminController(){
        Admin admin= (Admin) LoginPageController.user;
        admin.addNewAdmin();
    }

    public String viewUsers() {
        StringBuilder users = new StringBuilder();
        ArrayList<Admin> admins  = Admin.getAdmins();
        for (Admin admin : admins) {
            users.append(admin.getFirstname()+" "+admin.getLastname()+" "+admin.getUserID()+" "+admin.getUsername()+" "+admin.getPassword()+" "+admin.getEmail()+" "+admin.getPhoneNumber()+"\n");
        }
        ArrayList<Player> players = Player.getPlayers();
        for (Player player : players) {
            users.append(player.getFirstname()+" "+player.getLastname()+" "+player.getUserID()+" "+player.getUsername()+" "+player.getPassword()+" "+player.getEmail()+" "+player.getPhoneNumber()+"\n");
            users.append(player.getDaysPassedRegister()+" "+player.getScore()+" "+player.getMoney()+"\n"+"\n");

        }
        return String.valueOf(users);

    }

    public String getUser(int id) {
        StringBuilder userInfo = new StringBuilder();
        Player user = null;
        Player checker = null;
        try {
            user = Player.getPlayerByID(id);
            if (user.equals(checker))
            {
                return "player not found";
            }
        } catch (Exception e) {
            return "player not found";
        }

        userInfo.append(user.getFirstname()+" "+user.getLastname()+" "+user.getUserID()+" "+user.getUsername()+" "+user.getPassword()+" "+user.getEmail()+" "+user.getPhoneNumber()+"\n");
        userInfo.append(user.getDaysPassedRegister()+" "+user.getScore()+" "+user.getMoney()+"\n");
        for (Player friend : user.getFriends()) {
            userInfo.append(friend.getUserID()+" "+friend.getUsername()+"\n");
        }
        for (Log log : user.getGamesLog()) {
            userInfo.append(log.getGameName()+" "+log.getTimesOfPlay()+" "+log.getWins()+"\n");
        }
        for (Game suggestedGame : user.getSuggestedGames()) {
            userInfo.append(suggestedGame.getName()+" "+suggestedGame.getGameID()+"\n");
        }
        return String.valueOf(userInfo);
    }

    public String viewSuggestion(int id) {
        Player player = Player.getPlayerByID(id);
        StringBuilder games = new StringBuilder();
        try {
            for (Game suggestedGame : player.getSuggestedGames()) {
                games.append(suggestedGame.getName()+"\n");
            }
        } catch (Exception e) {
            games.append("nothing found");
        }


        return String.valueOf(games);
    }

    public void addSuggestion(int pid, int gid) {
        for (Player player : Player.getPlayers()) {
            if (player.getUserID()==pid){
                for (int i=0;i<player.getSuggestedGames().size();i++) {
                    if (player.getSuggestedGames().get(i).getGameID()==gid){
                        break;
                    }
                    else if (i==player.getSuggestedGames().size()-1){
                        for (Game game : Game.getGames()) {
                            if (game.getGameID()==gid) {
                                player.getSuggestedGames().add(game);
                            }
                        }
                    }
                }
            }
        }
    }

    public void removeSeggestion(int pid, int gid) {
        for (Player player : Player.getPlayers()) {
            if (player.getUserID()==pid){
                for (Game suggestedGame : player.getSuggestedGames()) {
                    if (suggestedGame.getGameID()==gid){
                        player.getSuggestedGames().remove(suggestedGame);
                        break;
                    }
                }
            }
        }
    }

    public String viewEvents() {
        StringBuilder events = new StringBuilder();
        for (Event event : Event.getEvents()) {
            if (event.isHasEnded()) {
                events.append(event.getGameName() + " " + event.getStartDate() + " " + event.getEndDate() + " " + event.getEventId() + " " + event.getEventScore() + "\n");
            }
        }
        for (Event event : Event.getEvents()) {
            if (!event.isHasEnded()) {
                events.append(event.getGameName() + " " + event.getStartDate() + " " + event.getEndDate() + " " + event.getEventId() + " " + event.getEventScore() + "\n");
            }
        }
        return String.valueOf(events);
    }
}
