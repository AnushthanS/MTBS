package Test;
import Login.UserLogin;

public class TestUserLogin {
    public static void main(String[] args) {
        UserLogin login = new UserLogin();
        login.inputPrompt();
        if(login.getAccess()) System.out.println("Access granted");
        else System.out.println("Access denied");
    }
}
