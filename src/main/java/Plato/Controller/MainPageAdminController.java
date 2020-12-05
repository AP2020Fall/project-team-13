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
}
