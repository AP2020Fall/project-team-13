package Plato.View;

import Plato.Controller.MainPageAdminController;

public class MainPageAdmin extends Page {
    MainPageAdminController mainPageAdminController;
    Page run() {
        mainPageAdminController.addNewAdminController();
        return null;
    }
}
