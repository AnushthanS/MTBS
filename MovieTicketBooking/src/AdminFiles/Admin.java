package AdminFiles;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {

    public void showUsers(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select * from userInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                System.out.println("Name         : "+rs.getString("Name"));
                System.out.println("Username     : "+rs.getString("Username"));
                System.out.println("Password     : "+rs.getString("Password"));
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
                System.out.println("Date       : "+rs.getString("date"));
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
                System.out.println("Date       : "+rs.getString("date"));
                System.out.println("Time slot  : "+rs.getString("time_slot"));
                System.out.println("Movie ID   : "+rs.getString("movie_id"));
                System.out.println("Theatre ID : "+rs.getString("theatre_id"));
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void modifyUser(){
    }
}
