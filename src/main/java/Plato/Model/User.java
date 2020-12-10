package Plato.Model;

import java.util.ArrayList;

public abstract class User {
    private static ArrayList<User> allUsers = new ArrayList<User>();
    private String firstname;
    private String lastname;
    private String username;
    private int userID;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean isAdmin;
    private static boolean isMainAdminJoinnt=false;
     public void editinformation(int userID, String type, String newValue){

     }
     public static User login(String username, String password){
         return null;
     }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        User.allUsers = allUsers;
    }

    public static boolean isIsMainAdminJoinnt() {
        return isMainAdminJoinnt;
    }

    public static void setIsMainAdminJoinnt(boolean isMainAdminJoinnt) {
        User.isMainAdminJoinnt = isMainAdminJoinnt;
    }

    public static void deleteUserAccount(int ID){
        for (User user : allUsers) {
            if (user.getUserID()==ID)
            {
                allUsers.remove(user);
                break;
            }
        }
    }

}
