package Plato.View;

import Plato.Controller.MainPageAdminController;
import Plato.Model.*;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;

public class MainPageAdmin extends Page {
    public static MainPageAdmin mainPageAdmin = new MainPageAdmin();
    private MainPageAdminController mainPageAdminController = MainPageAdminController.getInstance();
    public Page run() throws FileNotFoundException {
        seenPages.add(mainPageAdmin);
        String input;
        Matcher matcher;
        System.out.println("Main.Main Page Admin :");
while(true){
    Admin.updateAdmins();
    Player.updatePlayers();
    Game.updateGames();
    Log.updateLogs();
    Event.updateEvents();
    input=scanner.nextLine();
    if ((matcher = Commands.ADD_EVENT.getMatcher(input)).matches()) {
        try {
            System.out.println("enter game name");
            String gameName = scanner.nextLine();
            System.out.println("enter start date");
            String sdate = scanner.nextLine();
            System.out.println("enter end date");
            String edate = scanner.nextLine();
            System.out.println("enter score");
            int score = scanner.nextInt();
            mainPageAdmin.addEvent(gameName,sdate,edate, score);
        } catch (NumberFormatException e) {
            System.out.println("invalid form");
        }

    }
    else if ((matcher = Commands.VIEW_EVENTS.getMatcher(input)).matches()) {
        mainPageAdmin.viewEvents();
    }
    else if ((matcher = Commands.EDIT_EVENT.getMatcher(input)).matches()) {
        mainPageAdmin.editEvent(Integer.parseInt(matcher.group(1)),matcher.group(2),matcher.group(3));
    }
    else if ((matcher = Commands.REMOVE_EVENT.getMatcher(input)).matches()) {
        mainPageAdmin.removeEvent(Integer.parseInt(matcher.group(1)));
    }
    else if ((matcher = Commands.ADD_SUGGESTION.getMatcher(input)).matches()) {
        mainPageAdmin.addSuggestion(matcher.group(1),matcher.group(2));
    }
    else if ((matcher = Commands.VIEW_SUGGESTIONS.getMatcher(input)).matches()) {
        mainPageAdmin.viewSuggestions();
    }
    else if ((matcher = Commands.REMOVE_SUGGESTION.getMatcher(input)).matches()) {
        mainPageAdmin.removeSuggestion(Integer.parseInt(matcher.group(1)));
    }
    else if ((matcher = Commands.VIEW_USERS.getMatcher(input)).matches()) {
        mainPageAdmin.viewUsers();
    }
    else if ((matcher = Commands.VIEW_USER_PROFILE.getMatcher(input)).matches()) {
        mainPageAdmin.viewUser(Integer.parseInt(matcher.group(1)));
    }
    else if ((matcher = Commands.BACK.getMatcher(input)).matches()) {
        return seenPages.get(seenPages.size()-2);
    }
    else if ((matcher = Commands.VIEW_ACCOUNT_MENU.getMatcher(input)).matches()) {
        return UserPage.userPage;
    }
    else if ((matcher = Commands.ADD_BOT_MESSAGE.getMatcher(input)).matches()) {
        mainPageAdmin.addPlatoBotMessage(matcher.group(1));
    }
    else if ((matcher = Commands.HELP.getMatcher(input)).matches()) {
        System.out.println("Add event"+"\n"+"View events\n"+"Edit event\n"+"Remove event\n"+"Add suggestion\n"+"View suggestions\n"
        +"Remove suggestion\n"+"View users\n"+"View user profile\n"+"change game name\n"+"back\n"+"view account menu\n"+
                "add bot message\n"+"help");
    }
    else if ((matcher = Commands.CHANGE_GAME_NAME.getMatcher(input)).matches()) {
        MainPageAdmin.mainPageAdmin.mainPageAdminController.changeGameName(Integer.parseInt(matcher.group(1)),matcher.group(2));
    }
    else if ((matcher = Commands.ADD_NEW_ADMIN.getMatcher(input)).matches()) {
        System.out.println("enter email");
        String email = scanner.nextLine();
        System.out.println("enter firstname");
        String firstname = scanner.nextLine();
        System.out.println("enter lastname");
        String lastname = scanner.nextLine();
        System.out.println("enter phone number");
        String phoneNumber = scanner.nextLine();
        mainPageAdmin.addAdmin(matcher.group(1),matcher.group(2),email,firstname,lastname,phoneNumber);

    }
    else if (!input.equals("")){
        System.out.println("invalid command");
    }
}
    }

    private void viewUsers(){
        String users ;
        users=mainPageAdminController.viewUsers();
        System.out.println(users);
    }
    private void viewUser(int id){
        String userInfo ;
        userInfo = mainPageAdminController.getUser(id);
        System.out.println(userInfo);
    }
    private void viewSuggestions(){
        String suggestion = mainPageAdminController.viewSuggestions();
        System.out.println(suggestion);
    }
    private void addSuggestion(String username,String gamename){
        mainPageAdminController.addSuggestion(username,gamename);
    }
    private void removeSuggestion(int id){
        mainPageAdminController.removeSuggestion(id);
    }
    public void viewEvents(){
        String evets = mainPageAdminController.viewEvents();
        System.out.println(evets);
    }
    private void addEvent(String name,String sdate,String edate,int score){
        try {
            mainPageAdminController.addEvent(name,sdate,edate,score);
        } catch (Exception e) {
            System.out.println("invalid form");
        }
    }
    private void viewEvent(int id){
        String event;
        event=mainPageAdminController.viewEvent(id);
        System.out.println(event);
    }
    public void editEvent(int id,String field,String newValue){
        mainPageAdminController.editEvent(field,newValue,id);
    }
    private void removeEvent(int id){
        mainPageAdminController.removeEvent(id);
    }
    private void addPlatoBotMessage(String message){
        mainPageAdminController.addbotMessage(message);
    }
    private void startEvent(int id){
        mainPageAdminController.startEvent(id);
    }
    private void EndEvent(int id){
        mainPageAdminController.endEvent(id);
    }
    private void changeGameName(int id,String newName)
    {
        mainPageAdminController.changeGameName(id,newName);
    }
    private void addAdmin(String username, String password, String email, String firstname, String lastname, String phoneNumber) {
        try {
            mainPageAdminController.addNewAdminController(username,password,email,firstname,lastname,phoneNumber);
        } catch (Exception e) {
            System.out.println("username was used please try again with another username");
        }
    }

}
