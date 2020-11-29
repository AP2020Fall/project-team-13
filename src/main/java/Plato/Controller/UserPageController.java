package Plato.Controller;

public class UserPageController {

    public void changePasswordController(String old,String newPassword){
    LoginPageController.user.editinformation(LoginPageController.user.getUserID(),"password",newPassword);

    }
}
