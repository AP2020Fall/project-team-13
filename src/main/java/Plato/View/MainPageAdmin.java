package Plato.View;

import Plato.Controller.MainPageAdminController;

public class MainPageAdmin extends Page {
    MainPageAdminController mainPageAdminController;
    protected Page run() {
        mainPageAdminController.addNewAdminController();
        return null;
    }
}
