package Plato.Controller;

import Plato.Model.*;
import Plato.View.Commands;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;

public class MainPageAdminController {
    private static MainPageAdminController mainPageAdminController = new MainPageAdminController();

    public static MainPageAdminController getInstance() {
        return mainPageAdminController;
    }

    public void addNewAdminController(String username, String password, String email, String firstname, String lastname, String phoneNumber) throws Exception {
        Admin admin= (Admin) LoginPageController.user;
        admin.addNewAdmin(username,password,email,firstname,lastname,phoneNumber);
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
        for (int i=Log.getLogs().size()-1; i>0;i--)
        {
            if (Log.getLogs().get(i).getPlayer1().equals(user)||Log.getLogs().get(i).getPlayer2().equals(user))
            {
                userInfo.append(Log.getLogs().get(i).toString());
                userInfo.append("\n");
            }

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

    public void removeSuggestion(int id) {
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
                events.append(event.getGame().getName() + " start: " + event.getStartDate().getTime().toString() + " end: " + event.getEndDate().getTime().toString() + " " + event.getEventId() + " " + event.getEventScore() + "\n");
            }
        }
        for (Event event : Event.getEvents()) {
            if (!event.isHasEnded()) {
                events.append(event.getGame().getName() + " start: " + event.getStartDate().getTime().toString() + " end: " + event.getEndDate().getTime().toString() + " " + event.getEventId() + " " + event.getEventScore() + "\n");
            }
        }
        if (String.valueOf(events).equals(""))
        {
            return "no event found";
        }
        return String.valueOf(events);
    }

    public void addEvent(String name,String sdate,String edate,int score) throws Exception {
        Game game1 = null;
        for (int i=0;i<Game.getGames().size();i++) {
            if (Game.getGames().get(i).getName().equals(name))
            {
                game1=Game.getGames().get(i);
                break;
            }
            if (i==Game.getGames().size()-1)
            {
                Exception notFoundGame = new Exception();
                throw notFoundGame;
            }
        }
        Matcher matcher;
        GregorianCalendar ssdate=new GregorianCalendar();
        GregorianCalendar eedate = new GregorianCalendar();
        if ((matcher = Commands.DATER.getMatcher(sdate)).matches())
        {
            ssdate.set(Integer.parseInt(matcher.group(1)),Integer.parseInt(matcher.group(2)),Integer.parseInt(matcher.group(3)));
        }
        if ((matcher = Commands.DATER.getMatcher(edate)).matches())
        {

            eedate.set(Integer.parseInt(matcher.group(1)),Integer.parseInt(matcher.group(2)),Integer.parseInt(matcher.group(3)));
        }
        Event event = new Event(game1,ssdate,eedate,score);
        Event.getEvents().add(event);
    }

    public String viewEvent(int id) {
        StringBuilder theEvent= new StringBuilder();
        for (Event event : Event.getEvents()) {
            if(event.getEventId()==id){
                theEvent.append(event.getGame().getName() + " " + event.getStartDate() + " " + event.getEndDate() + " " + event.getEventId() + " " + event.getEventScore() + "\n");
                for (Player player : event.getPlayersOfThisEvent()) {
                    theEvent.append(player.getUsername()+" "+player.getUserID()+"\n");
                }
            }
        }
        return String.valueOf(theEvent);
    }
    public void editEvent(String field, String newvalue, int id){
        Game game1 = null;
        for (int i=0; i<Event.getEvents().size();i++) {
            if (Event.getEvents().get(i).getEventId()==id){
                if (field.equals("name")){
                    for (Game game : Game.getGames()) {
                        if (game.getName().equals(newvalue))
                        {
                            game1=game;
                            break;
                        }
                    }
                    Event.getEvents().get(i).setGame(game1);
                }
                else if (field.equals("startdate")){
                    Matcher matcher;
                    GregorianCalendar ssdate = new GregorianCalendar();
                    if ((matcher = Commands.DATER.getMatcher(newvalue)).matches())
                    {

                        ssdate.set(Integer.parseInt(matcher.group(1)),Integer.parseInt(matcher.group(2)),Integer.parseInt(matcher.group(3)));
                        Event.getEvents().get(i).setStartDate(ssdate);
                    }

                }
                else if(field.equals("enddate")){

                    Matcher matcher;
                    GregorianCalendar eedate = new GregorianCalendar();
                    if ((matcher = Commands.DATER.getMatcher(newvalue)).matches())
                    {

                        eedate.set(Integer.parseInt(matcher.group(1)),Integer.parseInt(matcher.group(2)),Integer.parseInt(matcher.group(3)));
                        Event.getEvents().get(i).setStartDate(eedate);
                    }

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

    public void addbotMessage(String message) {
        Admin.getMessages().add(message);
    }

    public void startEvent(int id) {

        for (Event event : Event.getEvents()) {
            if (event.getEventId()==id)
            {
                GregorianCalendar now = new GregorianCalendar();

                if (now.getTimeInMillis()>=event.getStartDate().getTimeInMillis())
                {
                    event.setHasStarted(true);
                }
            }
        }
    }

    public void endEvent(int id) {
        for (Event event : Event.getEvents()) {
            if (event.getEventId()==id)
            {
                GregorianCalendar now = new GregorianCalendar();

                if (now.getTimeInMillis()>=event.getStartDate().getTimeInMillis())
                {
                    event.setHasEnded(true);
                }
            }
        }
    }

    public void changeGameName(int id, String newName) {
        for (Game game : Game.getGames()) {
            if (game.getGameID()==id)
            {
                game.setName(newName);
            }
        }
    }
}
