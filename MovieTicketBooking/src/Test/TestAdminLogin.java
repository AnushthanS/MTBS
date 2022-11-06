package Test;

import Login.AdminLogin;

public class TestAdminLogin {
    public static void main(String[] args) {
        AdminLogin login = new AdminLogin();
        login.inputPrompt();
        if(login.getAccess()) System.out.println("Access granted");
        else System.out.println("Access denied");
    }
}
