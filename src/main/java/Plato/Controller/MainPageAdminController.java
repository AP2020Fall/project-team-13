package Plato.Controller;

import Plato.Model.Admin;

public class MainPageAdminController {

    public void addNewAdminController(){
        Admin admin= (Admin) LoginPageController.user;
        admin.addNewAdmin();
    }
}
