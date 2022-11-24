package AdminFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {

    public void showAdmins(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select username from adminInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Name: "+rs.getString("username"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void showUsers(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select * from userInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Name         : "+rs.getString("name"));
                System.out.println("Username     : "+rs.getString("username"));
                System.out.println("Password     : "+rs.getString("password"));
                System.out.println("Phone number : "+rs.getString("phone_number"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showTheatres(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select * from theatreInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Location          : "+rs.getString("location"));
                System.out.println("Theatre ID        : "+rs.getString("theatre_id"));
                System.out.println("Theatre           : "+rs.getString("theatre"));
                System.out.println("Screen            : "+rs.getString("screen"));
                System.out.println("Number of tickets : "+rs.getString("no_of_tickets"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showMovies(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select * from movieInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Movie ID         : "+rs.getString("movie_id"));
                System.out.println("Movie Name       : "+rs.getString("movie_name"));
                System.out.println("Rating           : "+rs.getString("rating"));
                System.out.println("Genre            : "+rs.getString("genre"));
                System.out.println("Language         : "+rs.getString("language"));
                System.out.println("Theatre ID       : "+rs.getString("theatre_id"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showTimings(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select * from showInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Theatre ID : "+rs.getString("theatre_id"));
                System.out.println("Movie ID   : "+rs.getString("movie_id"));
                System.out.println("Time       : "+rs.getString("time"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showBookings(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select * from bookingInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Username   : "+rs.getString("username"));
                System.out.println("Time slot  : "+rs.getString("time_slot"));
                System.out.println("Movie ID   : "+rs.getString("movie_id"));
                System.out.println("Theatre ID : "+rs.getString("theatre_id"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void changeName(String Username, String newName) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "update userInfo set name = ? where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newName);
            pst.setString(2, Username);
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changePassword(String Username, String newPassword) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "update userInfo set password = ? where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newPassword);
            pst.setString(2, Username);
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void changePhoneNo(String Username, String newPhoneNo) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "update userInfo set phone_number = ? where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newPhoneNo);
            pst.setString(2, Username);
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String Username){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "delete from userInfo where username = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, Username);
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void addMovie(String movieID, String movieName, String rating, String genre, String language, String theatreID){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "insert into movieInfo values(?,?,?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, movieID);
            pst.setString(2, movieName);
            pst.setString(3, rating);
            pst.setString(4, genre);
            pst.setString(5, language);
            pst.setString(6, theatreID);
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteMovie(String movieID){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "delete from movieInfo where movie_id = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, movieID);
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBooking(String Username, String movieID){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "delete from bookingInfo where username = ? and movie_id = ?;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, Username);
            pst.setString(2, movieID);
            pst.execute();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
