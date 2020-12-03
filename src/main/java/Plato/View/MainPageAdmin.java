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
}
