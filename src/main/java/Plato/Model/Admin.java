package Plato.Model;

import org.json.simple.JSONArray;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Admin extends User{
    private static ArrayList<Admin> admins =new ArrayList<Admin>();
    private static ArrayList<String> messages = new ArrayList<String>();
    public static ArrayList<Admin> getAdmins() {
        return admins;
    }

    public static void addNewAdmin(String username, String password, String email, String firstname, String lastname, String phoneNumber) throws Exception {
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
        User.getAllUsers().add(admin);
        admins.add(admin);

    }

    public Admin() {
    }

    public static ArrayList<String> getMessages() {
        return messages;
    }

    public static void setMessages(ArrayList<String> messages) {
        Admin.messages = messages;
    }

    //update the admins that has been saved in file
    public static void updateAdmins() throws FileNotFoundException {
        JSONArray ja = new JSONArray();
        int n = admins.size();
        for (int i = 0; i < n; i++) {
            Map m = new LinkedHashMap(9);
            m.put("firstname", admins.get(i).getFirstname());
            m.put("lastname", admins.get(i).getLastname());
            m.put("username", admins.get(i).getUsername());
            m.put("userID", admins.get(i).getUserID());
            m.put("password", admins.get(i).getPassword());
            m.put("email", admins.get(i).getEmail());
            m.put("phoneNumber", admins.get(i).getPhoneNumber());
            m.put("isMainAdminJoinnt", isIsMainAdminJoinnt());
            m.put("messages", getMessages());
            ja.add(m);
        }
        PrintWriter pw = new PrintWriter("admins.json");
        pw.write(ja.toJSONString());
        pw.flush();
        pw.close();
    }
}
