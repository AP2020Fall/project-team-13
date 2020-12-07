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

    public String viewSuggestions() {
        StringBuilder games = new StringBuilder();


        try {
            for (Player player : Player.getPlayers()) {
                for (int i=0;i<player.getSuggestedGames().size();i++)
                {
                    games.append(player.getSuggestedGames().get(i).getName()+" "+player.getUsername()+" "+player.getSuggestionID().get(i)+"\n");
                }
            }
        } catch (Exception e) {
            games.append("nothing found");
        }


        return String.valueOf(games);
    }

    public void addSuggestion(String username, String gamename) {
        int max=0;
        for (Player player : Player.getPlayers()) {
            if (player.getUsername().equals(username)){
                for (int i=0;i<player.getSuggestedGames().size();i++) {
                    if (player.getSuggestedGames().get(i).getName().equals(gamename)){
                        break;
                    }
                    else if (i==player.getSuggestedGames().size()-1){
                        for (Game game : Game.getGames()) {
                            if (game.getName().equals(gamename)) {
                                player.getSuggestedGames().add(game);
                                for (Player player1 : Player.getPlayers()) {
                                    for (Integer integer : player1.getSuggestionID()) {
                                        if (integer>max){
                                            max=integer;
                                        }
                                    }
                                }
                                player.getSuggestionID().add(max);
                            }
                        }
                    }
                }
            }
        }
    }

    public void removeSeggestion(int id) {
        for (Player player : Player.getPlayers()) {
            for (int i=0;i<player.getSuggestionID().size();i++)
            {
                if (i == player.getSuggestionID().get(i)){
                    player.getSuggestionID().remove(i);
                    player.getSuggestedGames().remove(i);
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

    public void addEvent(String name,String sdate,String edate,int score){
        Event event = new Event(name,sdate,edate,score,Event.getEvents().size());
        Event.getEvents().add(event);
    }

    public String viewEvent(int id) {
        StringBuilder theEvent= new StringBuilder();
        for (Event event : Event.getEvents()) {
            if(event.getEventId()==id){
                theEvent.append(event.getGameName() + " " + event.getStartDate() + " " + event.getEndDate() + " " + event.getEventId() + " " + event.getEventScore() + "\n");
                for (Player player : event.getPlayersOfThisEvent()) {
                    theEvent.append(player.getUsername()+" "+player.getUserID()+"\n");
                }
            }
        }
        return String.valueOf(theEvent);
    }
    public void editEvent(String field, String newvalue, int id){
        for (int i=0; i<Event.getEvents().size();i++) {
            if (Event.getEvents().get(i).getEventId()==id){
                if (field.equals("name")){
                    Event.getEvents().get(i).setGameName(newvalue);
                }
                else if (field.equals("startdate")){
                    Event.getEvents().get(i).setStartDate(newvalue);
                }
                else if(field.equals("enddate")){
                    Event.getEvents().get(i).setEndDate(newvalue);
                }
                else if(field.equals("score")){
                    Event.getEvents().get(i).setEventScore(Integer.parseInt(newvalue));
                }
            }
        }
    }

    public void removeEvent(int id) {
        for (Event event : Event.getEvents()) {
            if (event.getEventId()==id){
                Event.getEvents().remove(event);
            }
        }
    }
}
