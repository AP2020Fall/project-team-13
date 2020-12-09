package Plato.Model;

import java.util.ArrayList;
import java.util.Date;

public class Event {
    private static ArrayList<Event> events = new ArrayList<Event>();
    private ArrayList<Player> playersOfThisEvent = new ArrayList<Player>();
    private Game game = new Game();
    private Date startDate = new Date();
    private Date endDate = new Date();
    private int eventScore;
    private int eventId;
    private boolean hasStarted;
    private boolean hasEnded;

    public Event( Game game, Date startDate, Date endDate, int eventScore) {
        this.playersOfThisEvent = new ArrayList<Player>();
        this.game = game;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventScore = eventScore;
        this.eventId = events.size()+1;
        this.hasStarted = false;
        this.hasEnded = false;
    }

    public static void createEvent(Game game, Date startDate, Date endDate, int eventScore, int eventId){
        Event event = new Event(game, startDate, endDate, eventScore);
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

    public void setPlayersOfThisEvent(ArrayList<Player> playersOfThisEvent) {
        this.playersOfThisEvent = playersOfThisEvent;
    }

    public Game getGame() {
        return game;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
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

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
