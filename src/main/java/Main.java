import BattleSea.Controller.BattleSea;
import Plato.Controller.LoginPageController;
import Plato.Model.*;
import Plato.View.LoginPage;
import Plato.View.Page;
import Reversi.ReversiController;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        File games = new File("C:\\Users\\Mehdi1321Ali\\IdeaProjects\\AP-HW3\\games.json");
        if(games.exists() && !games.isDirectory()) {
            Object obj = new JSONParser().parse(new FileReader("games.json"));
            JSONArray ja = (JSONArray) obj;
            int n = ja.size();
            for (int i = 0; i < n; i++) {
                Game.addGame((String) ((Map)(ja.get(i))).get("name"), Math.toIntExact((Long) ((Map) (ja.get(i))).get("gameID")));
            }
        }
        File admins = new File("C:\\Users\\Mehdi1321Ali\\IdeaProjects\\AP-HW3\\admins.json");
        if(admins.exists() && !admins.isDirectory()) {
            Object obj = new JSONParser().parse(new FileReader("admins.json"));
            JSONArray ja = (JSONArray) obj;
            int n = ja.size();
            for (int i = 0; i < n; i++) {
                Admin.addNewAdmin((String) ((Map)(ja.get(i))).get("username"), (String) ((Map)(ja.get(i))).get("password"),
                        (String) ((Map)(ja.get(i))).get("email"), (String) ((Map)(ja.get(i))).get("firstname"),
                        (String) ((Map)(ja.get(i))).get("lastname"), (String) ((Map)(ja.get(i))).get("phoneNumber"));
                Admin.getAdmins().get(i).setUserID(Math.toIntExact((Long) ((Map) (ja.get(i))).get("userID")));
                if(i == 0)
                    Admin.setIsMainAdminJoinnt((String) ((Map)(ja.get(i))).get("isMainAdminJoinnt"));
                Admin.setMessages((ArrayList<String>) ((Map)(ja.get(i))).get("messages"));
            }
        }
        File players = new File("C:\\Users\\Mehdi1321Ali\\IdeaProjects\\AP-HW3\\players.json");
        if(players.exists() && !players.isDirectory()) {
            Object obj = new JSONParser().parse(new FileReader("players.json"));
            JSONArray ja = (JSONArray) obj;
            int n = ja.size();
            for (int i = 0; i < n; i++) {
                Player.addNewPlayer((String) ((Map)(ja.get(i))).get("username"), (String) ((Map)(ja.get(i))).get("password"),
                        (String) ((Map)(ja.get(i))).get("email"), (String) ((Map)(ja.get(i))).get("firstname"),
                        (String) ((Map)(ja.get(i))).get("lastname"), (String) ((Map)(ja.get(i))).get("phoneNumber"));
                Player.getPlayers().get(i).setUserID(Math.toIntExact((Long) ((Map) (ja.get(i))).get("userID")));
                Player.getPlayers().get(i).setRegisterTime((LocalDate) ((Map)(ja.get(i))).get("registerTime"));
                Player.getPlayers().get(i).setMoney(Math.toIntExact((Long) ((Map) (ja.get(i))).get("money")));
                Player.getPlayers().get(i).setScore(Math.toIntExact((Long) ((Map) (ja.get(i))).get("score")));
                Player.getPlayers().get(i).setReversiWins(Math.toIntExact((Long) ((Map) (ja.get(i))).get("reversiWins")));
                Player.getPlayers().get(i).setReversiDraws(Math.toIntExact((Long) ((Map) (ja.get(i))).get("reversiDraws")));
                Player.getPlayers().get(i).setReversiLosses(Math.toIntExact((Long) ((Map) (ja.get(i))).get("reversiLosses")));
                Player.getPlayers().get(i).setReversiPoints(Math.toIntExact((Long) ((Map) (ja.get(i))).get("reversiPoints")));
                Player.getPlayers().get(i).setReversiPlayedCount(Math.toIntExact((Long) ((Map) (ja.get(i))).get("reversiPlayedCount")));
                Player.getPlayers().get(i).setBattleSeaWins(Math.toIntExact((Long) ((Map) (ja.get(i))).get("battleSeaWins")));
                Player.getPlayers().get(i).setBattleSeaDraws(Math.toIntExact((Long) ((Map) (ja.get(i))).get("battleSeaDraws")));
                Player.getPlayers().get(i).setBattleSeaLosses(Math.toIntExact((Long) ((Map) (ja.get(i))).get("battleSeaLosses")));
                Player.getPlayers().get(i).setBattleSeaPoints(Math.toIntExact((Long) ((Map) (ja.get(i))).get("battleSeaPoints")));
                Player.getPlayers().get(i).setBattleSeaPlayedCount(Math.toIntExact((Long) ((Map) (ja.get(i))).get("battleSeaPlayedCount")));
                Player.getPlayers().get(i).setFriends((ArrayList<Integer>) ((Map)(ja.get(i))).get("friends"));
                Player.getPlayers().get(i).setFriendRequests((ArrayList<Integer>) ((Map)(ja.get(i))).get("friendRequests"));
                Player.getPlayers().get(i).setSuggestedGames((ArrayList<Integer>) ((Map)(ja.get(i))).get("suggestedGames"));
                Player.getPlayers().get(i).setSuggestionID((ArrayList<Integer>) ((Map)(ja.get(i))).get("suggestionID"));
                Player.getPlayers().get(i).setFavorites((ArrayList<Integer>) ((Map)(ja.get(i))).get("favorites"));
                Player.getPlayers().get(i).setMessages((ArrayList<String>) ((Map)(ja.get(i))).get("messages"));
                Player.getPlayers().get(i).setMessagesShown((ArrayList<Boolean>) ((Map)(ja.get(i))).get("messagesShown"));
            }
        }
        File logs = new File("C:\\Users\\Mehdi1321Ali\\IdeaProjects\\AP-HW3\\logs.json");
        if(logs.exists() && !logs.isDirectory()) {
            Object obj = new JSONParser().parse(new FileReader("logs.json"));
            JSONArray ja = (JSONArray) obj;
            int n = ja.size();
            for (int i = 0; i < n; i++) {
                Log.addLog(Math.toIntExact((Long) ((Map) (ja.get(i))).get("gameID")), Player.getPlayerByID(Math.toIntExact((Long) ((Map) (ja.get(i))).get("player1"))),
                        Player.getPlayerByID(Math.toIntExact((Long) ((Map) (ja.get(i))).get("player2"))),
                        Player.getPlayerByID(Math.toIntExact((Long) ((Map) (ja.get(i))).get("winner"))));
            }
        }
        File events = new File("C:\\Users\\Mehdi1321Ali\\IdeaProjects\\AP-HW3\\events.json");
        if(events.exists() && !events.isDirectory()) {
            Object obj = new JSONParser().parse(new FileReader("events.json"));
            JSONArray ja = (JSONArray) obj;
            int n = ja.size();
            for (int i = 0; i < n; i++) {
                Game game = new Game();
                if(Math.toIntExact((Long) ((Map) (ja.get(i))).get("game")) == 1)
                    game = ReversiController.reversiController;
                else if(Math.toIntExact((Long) ((Map) (ja.get(i))).get("game")) == 2)
                    game = BattleSea.battleSea;
                Event event = new Event(game, (GregorianCalendar) ((Map)(ja.get(i))).get("startTime"),
                        (GregorianCalendar) ((Map)(ja.get(i))).get("endTime"),
                        Math.toIntExact((Long) ((Map) (ja.get(i))).get("eventScore")));
                event.setEventId(Math.toIntExact((Long) ((Map) (ja.get(i))).get("eventID")));
                event.setHasStarted((Boolean) ((Map)(ja.get(i))).get("hasStarted"));
                event.setHasEnded((Boolean) ((Map)(ja.get(i))).get("hasEnded"));
                event.setPlayersOfThisEvent((ArrayList<Integer>) ((Map)(ja.get(i))).get("playersOfThisEvent"));
            }
        }
        Page page = LoginPage.getInstance();
        LoginPageController.addTheGames();

        while (page != null) {
            page = page.run();
        }
    }


}
