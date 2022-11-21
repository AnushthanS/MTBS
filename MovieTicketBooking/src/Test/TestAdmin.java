package Test;

import AdminFiles.Admin;
import Login.AdminLogin;

public class TestAdmin {
    public static void main(String[] args) {
        AdminLogin login = new AdminLogin();
        login.inputPrompt();
        if(login.getAccess()) {
            Admin admin = new Admin();
//            admin.showUsers();
//            admin.showTheatres();
//            admin.showMovies();
//            admin.showTimings();
            admin.showBookings();
        } else System.out.println("No such user");
    }
}
