package Plato.Model;

import java.util.ArrayList;

public class Admin extends User{
    private static ArrayList<Admin> admins =new ArrayList<Admin>();
    private static ArrayList<String> messages = new ArrayList<String>();
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public  void addNewAdmin(String username, String password, String email, String firstname, String lastname, String phoneNumber) throws Exception {
        for (User allUser : User.getAllUsers()) {
            if ((allUser.getUsername().equals(username))||(allUser.getEmail().equals(email)))
            {
                Exception exception = new Exception();
                throw exception;
            }
        }
        Admin admin = new Admin();
        admin.setAdmin(true);
        admin.setEmail(email);
        admin.setFirstname(firstname);
        admin.setLastname(lastname);
        admin.setPassword(password);
        admin.setPhoneNumber(phoneNumber);
        admin.setUsername(username);
        admin.setUserID(User.getAllUsers().size()+1);
        User.getAllUsers().add(admin);
        admins.add(admin);

    }

    public Admin() {
    }

    public static ArrayList<String> getMessages() {
        return messages;
    }
}
