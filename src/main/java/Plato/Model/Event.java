package Plato.Model;

import org.json.simple.JSONArray;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Event {
    private static ArrayList<Event> events = new ArrayList<Event>();
    private ArrayList<Player> playersOfThisEvent = new ArrayList<Player>();
    private Game game;
    private GregorianCalendar startDate;
    private GregorianCalendar endDate;
    private int eventScore;
    private int eventId;
    private boolean hasStarted;
    private boolean hasEnded;

    public Event( Game game, GregorianCalendar startDate, GregorianCalendar endDate, int eventScore) {
        this.game = game;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventScore = eventScore;
        this.eventId = events.size()+1;
        this.hasStarted = false;
        this.hasEnded = false;
    }

    public static void addEvent(Event event){
        events.add(event);
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public static void setEvents(ArrayList<Event> events) {
        Event.events = events;
    }

    public ArrayList<Player> getPlayersOfThisEvent() {
        return playersOfThisEvent;
    }

    public void setPlayersOfThisEvent(ArrayList<Integer> playersOfThisEvent) {
        int n = playersOfThisEvent.size();
        for (int i = 0; i < n; i++) {
            this.playersOfThisEvent.add(Player.getPlayerByID(playersOfThisEvent.get(i)));
        }
    }

    public Game getGame() {
        return game;
    }

    public int getEventScore() {
        return eventScore;
    }

    public void setEventScore(int eventScore) {
        this.eventScore = eventScore;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public boolean isHasStarted() {
        return hasStarted;
    }

    public void setHasStarted(boolean hasStarted) {
        this.hasStarted = hasStarted;
    }

    public boolean isHasEnded() {
        return hasEnded;
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public void startEvent(int eventId){

    }
    public void endEvent(int eventId){

    }
    public static void removeEvent(int eventId){

    }
    public static Event getEvent(int eventId){
        return null;
    }

    public void joinEvent(Player player){

    }
    public void quitEvent(Player player){

    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GregorianCalendar getStartDate() {
        return startDate;
    }

    public void setStartDate(GregorianCalendar startDate) {
        this.startDate = startDate;
    }

    public GregorianCalendar getEndDate() {
        return endDate;
    }

    public void setEndDate(GregorianCalendar endDate) {
        this.endDate = endDate;
    }

    //update the admins that has been saved in file
    public static void updateEvents() throws FileNotFoundException {
        JSONArray ja = new JSONArray();
        int n = events.size();
        for (int i = 0; i < n; i++) {
            Map m = new LinkedHashMap(8);
            m.put("game", events.get(i).getGame().getGameID());
            m.put("startDate", events.get(i).getStartDate());
            m.put("endDate", events.get(i).getEndDate());
            m.put("eventScore", events.get(i).getEventScore());
            m.put("eventID", events.get(i).getEventId());
            m.put("hasStarted", events.get(i).isHasStarted());
            m.put("hasEnded", events.get(i).isHasEnded());
            int t = events.get(i).getPlayersOfThisEvent().size();
            ArrayList<Integer> players = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                players.add(events.get(i).getPlayersOfThisEvent().get(j).getUserID());
            }
            m.put("playersOfThisEvent", players);
            ja.add(m);
        }
        PrintWriter pw = new PrintWriter("events.json");
        pw.write(ja.toJSONString());
        pw.flush();
        pw.close();
    }
}
