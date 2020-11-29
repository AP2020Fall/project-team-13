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
