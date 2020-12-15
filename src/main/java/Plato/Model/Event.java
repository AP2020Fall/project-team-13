package Plato.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

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
}
