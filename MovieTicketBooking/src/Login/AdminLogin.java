package Login;

import java.sql.*;
import java.util.Scanner;

public class AdminLogin implements LoginInterface{

    private String adminName;
    private String password;

    private boolean access;

    public boolean getAccess() {
        return access;
    }
    private void setAccess(boolean access) {this.access = access;}

    public AdminLogin(){
        setAdminName("");
        setPassword("");
        access = false;
    }
    public String getAdminName() {
        return adminName;
    }

    private void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    private String getPassword() {
        return password;
    }
    private void setPassword(String password) {
        this.password = password;
    }
    @Override
    public void inputPrompt(){
        System.out.print("Enter Admin name: ");
        Scanner scanner = new Scanner(System.in);
        setAdminName(scanner.next());

        System.out.print("Enter password: ");

        setPassword(scanner.next());
        authentication();
    }

    @Override
    public void authentication() {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select count(*) from adminInfo where admin_name = ? and password = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, getAdminName());
            pst.setString(2, getPassword());
            ResultSet rs = pst.executeQuery();
            rs.next();
            setAccess(rs.getString(1).equals("1"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
