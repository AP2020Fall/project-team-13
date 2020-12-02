package Plato.View;

import Plato.Controller.MainPageAdminController;

public class MainPageAdmin extends Page {
    private static MainPageAdmin mainPageAdmin = new MainPageAdmin();
    private MainPageAdminController mainPageAdminController = MainPageAdminController.getInstance();
    public Page run() {
        mainPageAdminController.addNewAdminController();
        return null;
    }
}
