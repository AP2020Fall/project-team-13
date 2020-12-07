package Plato.View;

import Plato.Controller.MainPageAdminController;

public class MainPageAdmin extends Page {
    private static MainPageAdmin mainPageAdmin = new MainPageAdmin();
    private MainPageAdminController mainPageAdminController = MainPageAdminController.getInstance();
    public Page run() {
        mainPageAdminController.addNewAdminController();
        return null;
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
    public void editEvent(String field,String newValue,int id){
        mainPageAdminController.editEvent(field,newValue,id);
    }
    private void removeEvent(int id){
        mainPageAdminController.removeEvent(id);
    }
}
