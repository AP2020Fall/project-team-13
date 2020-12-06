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
    private void viewSuugestios(int id){
        String suggestion = mainPageAdminController.viewSuggestion(id);
        System.out.println(suggestion);
    }
    private void addSuggestion(int pid,int gid){
        mainPageAdminController.addSuggestion(pid,gid);
    }
    private void removeSeggestion(int pid,int gid){
        mainPageAdminController.removeSeggestion(pid,gid);
    }
    private void viewEvents(){
        String evets = mainPageAdminController.viewEvents();
        System.out.println(evets);
    }
}
