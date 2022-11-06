package Login;

import java.sql.*;
import java.util.Scanner;

public class AdminLogin implements LoginInterface{

    private String adminname;
    private String password;

    private boolean access;

    public boolean getAccess() {
        return access;
    }
    private void setAccess(boolean access) {this.access = access;}

    public AdminLogin(){
        setAdminname("");
        setPassword("");
        access = false;
    }
    private String getAdminname() {
        return adminname;
    }

    private void setAdminname(String adminname) {
        this.adminname = adminname;
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
        setAdminname(scanner.next());

        System.out.print("Enter password: ");

        setPassword(scanner.next());
        authentication();
    }

    @Override
    public void authentication() {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select count(*) from Admin where adminname = ? and password = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, getAdminname());
            pst.setString(2, getPassword());
            ResultSet rs = pst.executeQuery();
            rs.next();
            setAccess(rs.getString(1).equals("1"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
