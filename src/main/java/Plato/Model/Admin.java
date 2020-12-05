package Plato.Model;

import java.util.ArrayList;

public class Admin extends User{
    private static ArrayList<Admin> admins =new ArrayList<Admin>();

    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public  void addNewAdmin(){

    }

    public static void deleteAdminAccount(int ID){
        for (Admin admin : admins) {
            if (admin.getUserID()==ID)
            {
                admins.remove(admin);
                break;
            }
        }
    }
}
