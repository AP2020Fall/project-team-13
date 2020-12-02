package Plato.Controller;

import Plato.Model.Admin;

public class MainPageAdminController {
    private static MainPageAdminController mainPageAdminController = new MainPageAdminController();

    public static MainPageAdminController getInstance() {
        return mainPageAdminController;
    }

    public void addNewAdminController(){
        Admin admin= (Admin) LoginPageController.user;
        admin.addNewAdmin();
    }
}
