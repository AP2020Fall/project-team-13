package Plato.Model;

import java.util.ArrayList;

public class Event {
    private static ArrayList<Event> events = new ArrayList<Event>();
    private ArrayList<Player> playersOfThisEvent = new ArrayList<Player>();
    private String gameName;
    private String startDate;
    private String endDate;
    private int eventScore;
    private int eventId;
    private boolean hasStarted;
    private boolean hasEnded;

    public Event(String gameName, String startDate, String endDate, int eventScore, int eventId) {
        this.gameName = gameName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventScore = eventScore;
        this.eventId = eventId;
        this.hasStarted = false;
        this.hasEnded = false;

    }

    public static void createEvent(String gameName, String startDate, String endDate, int eventScore, int eventId){
        Event event = new Event(gameName, startDate, endDate, eventScore, eventId);
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

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

}
