package Plato.View;

import Plato.Controller.MainPageAdminController;

import java.util.regex.Matcher;

public class MainPageAdmin extends Page {
    public static MainPageAdmin mainPageAdmin = new MainPageAdmin();
    private MainPageAdminController mainPageAdminController = MainPageAdminController.getInstance();
    public Page run() {
        seenPages.add(mainPageAdmin);
        String input;
        Matcher matcher;
while(true){
    input=scanner.nextLine();
    if ((matcher = Commands.ADD_EVENT.getMatcher(input)).matches())
    {
        mainPageAdmin.addEvent(matcher.group(1),matcher.group(2),matcher.group(3), Integer.parseInt(matcher.group(4)));
    }
    else if ((matcher = Commands.VIEW_EVENTS.getMatcher(input)).matches())
    {
        mainPageAdmin.viewEvents();
    }
    else if ((matcher = Commands.EDIT_EVENT.getMatcher(input)).matches())
    {
        mainPageAdmin.editEvent(Integer.parseInt(matcher.group(1)),matcher.group(2),matcher.group(3));
    }
    else if ((matcher = Commands.REMOVE_EVENT.getMatcher(input)).matches())
    {
        mainPageAdmin.removeEvent(Integer.parseInt(matcher.group(1)));
    }
    else if ((matcher = Commands.ADD_SUGGESTION.getMatcher(input)).matches())
    {
        mainPageAdmin.addSuggestion(matcher.group(1),matcher.group(2));
    }
    else if ((matcher = Commands.VIEW_SUGGESTIONS.getMatcher(input)).matches())
    {
        mainPageAdmin.viewSuugestions();
    }
    else if ((matcher = Commands.REMOVE_SUGGESTION.getMatcher(input)).matches())
    {
        mainPageAdmin.removeSeggestion(Integer.parseInt(matcher.group(1)));
    }
    else if ((matcher = Commands.VIEW_USERS.getMatcher(input)).matches())
    {
        mainPageAdmin.viewUsers();
    }
    else if ((matcher = Commands.VIEW_USER_PROFILE.getMatcher(input)).matches())
    {
        mainPageAdmin.viewuser(Integer.parseInt(matcher.group(1)));
    }
    else if ((matcher = Commands.BACK.getMatcher(input)).matches())
    {
        return seenPages.get(seenPages.size()-2);
    }
    else if ((matcher = Commands.VIEW_ACCOUNT_MENU.getMatcher(input)).matches())
    {
        return UserPage.userPage;
    }
    else if ((matcher = Commands.ADD_BOT_MESSAGE.getMatcher(input)).matches())
    {
        mainPageAdmin.addplatobotMessage(matcher.group(1));
    }
    else if ((matcher = Commands.HELP.getMatcher(input)).matches())
    {
        System.out.println("Add event"+"\n"+"View events\n"+"Edit event\n"+"Remove event\n"+"Add suggestion\n"+"View suggestions\n"
        +"Remove suggestion\n"+"View users\n"+"View user profile\n");
    }
    else {
        System.out.println("invalid command");
    }
}
    }

    private void viewUsers(){
        String users ;
        users=mainPageAdminController.viewUsers();
        System.out.println(users);
    }
    private void viewuser(int id){
        String userInfo ;
        userInfo = mainPageAdminController.getUser(id);
        System.out.println(userInfo);
    }
    private void viewSuugestions(){
        String suggestion = mainPageAdminController.viewSuggestions();
        System.out.println(suggestion);
    }
    private void addSuggestion(String username,String gamename){
        mainPageAdminController.addSuggestion(username,gamename);
    }
    private void removeSeggestion(int id){
        mainPageAdminController.removeSeggestion(id);
    }
    private void viewEvents(){
        String evets = mainPageAdminController.viewEvents();
        System.out.println(evets);
    }
    private void addEvent(String name,String sdate,String edate,int score){
        mainPageAdminController.addEvent(name,sdate,edate,score);
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
    private void addplatobotMessage(String message){
        mainPageAdminController.addbotMessage(message);
    }
    private void startEvent(int id){
        mainPageAdminController.startEvent(id);
    }
    private void endtEvent(int id){
        mainPageAdminController.endEvent(id);
    }
}
