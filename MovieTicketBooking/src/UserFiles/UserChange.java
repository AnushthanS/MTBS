package UserFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserChange {

    private final User user;

    private User getUser(){
        return this.user;
    }
    public UserChange(User user) {
        this.user = user;
    }

    public void changeName(String newName) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "update User set name = ? where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newName);
            pst.setString(2, getUser().getUsername());
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String newPassword) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "update User set password = ? where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newPassword);
            pst.setString(2, getUser().getUsername());
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changePhoneNo(String newPhoneNo) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "update User set phone_number = ? where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newPhoneNo);
            pst.setString(2, getUser().getUsername());
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
