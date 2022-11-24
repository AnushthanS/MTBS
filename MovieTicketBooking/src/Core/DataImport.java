package Core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataImport {

    public void refresh(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "truncate table bookingInfo;";
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();

            query = "truncate table userInfo;";
            pst = con.prepareStatement(query);
            pst.executeUpdate();

            query = "truncate table showInfo;";
            pst = con.prepareStatement(query);
            pst.executeUpdate();

            query = "truncate table adminInfo;";
            pst = con.prepareStatement(query);
            pst.executeUpdate();

            query = "truncate table theatreInfo;";
            pst = con.prepareStatement(query);
            pst.executeUpdate();

            query = "truncate table movieInfo;";
            pst = con.prepareStatement(query);
            pst.executeUpdate();


            bookingInfo();
            userInfo();
            showInfo();
            adminInfo();
            theatreInfo();
            movieInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void bookingInfo(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query = "insert into bookingInfo values(?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);

            BufferedReader lineReader = new BufferedReader(new FileReader("/Users/anushthan/Development/MTBS/MovieTicketBooking/src/Database/bookingInfo.csv"));

            String fileText;
            int i = 0;
            while((fileText = lineReader.readLine()) != null){
                i++;
                if(i == 1) continue;
                String[] data = fileText.split(",");
                String username = data[0].substring(1, data[0].length() - 1);
                String time = data[1].substring(1, data[1].length() - 1);
                pst.setString(1, username);
                pst.setString(2, time);
                pst.setInt(3, Integer.parseInt(data[2]));
                pst.setInt(4, Integer.parseInt(data[3]));

                pst.executeUpdate();
            }
            System.out.println("Successfully refreshed bookingInfo");
            lineReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void userInfo(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query = "insert into userInfo values(?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);

            BufferedReader lineReader = new BufferedReader(new FileReader("/Users/anushthan/Development/MTBS/MovieTicketBooking/src/Database/userInfo.csv"));

            String fileText;
            int i = 0;
            while((fileText = lineReader.readLine()) != null){
                i++;
                if(i == 1) continue;
                String[] data = fileText.split(",");
                String name = data[0].substring(1, data[0].length() - 1);
                String username = data[1].substring(1, data[1].length() - 1);
                String password = data[2].substring(1, data[2].length() - 1);
                String phone = data[3].substring(1, data[3].length() - 1);
                pst.setString(1, name);
                pst.setString(2, username);
                pst.setString(3, password);
                pst.setString(4, phone);

                pst.executeUpdate();
            }
            System.out.println("Successfully refreshed userInfo");
            lineReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void showInfo(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query = "insert into showInfo values(?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);

            BufferedReader lineReader = new BufferedReader(new FileReader("/Users/anushthan/Development/MTBS/MovieTicketBooking/src/Database/showInfo.csv"));

            String fileText;
            int i = 0;
            while((fileText = lineReader.readLine()) != null){
                i++;
                if(i == 1) continue;
                String[] data = fileText.split(",");

                String time = data[2];
                pst.setInt(1, Integer.parseInt(data[0]));
                pst.setInt(2, Integer.parseInt(data[1]));
                pst.setString(3, time);

                pst.executeUpdate();
            }
            System.out.println("Successfully refreshed showInfo");
            lineReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void adminInfo(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query = "insert into adminInfo values(?, ?);";
            PreparedStatement pst = con.prepareStatement(query);

            BufferedReader lineReader = new BufferedReader(new FileReader("/Users/anushthan/Development/MTBS/MovieTicketBooking/src/Database/adminInfo.csv"));

            String fileText;
            int i = 0;
            while((fileText = lineReader.readLine()) != null){
                i++;
                if(i == 1) continue;
                String[] data = fileText.split(",");
                String username = data[0].substring(1, data[0].length() - 1);
                String pass = data[1].substring(1, data[1].length() - 1);

                pst.setString(1, username);
                pst.setString(2, pass);

                pst.executeUpdate();
            }
            System.out.println("Successfully refreshed adminInfo");
            lineReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void theatreInfo(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query = "insert into theatreInfo values(?, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);

            BufferedReader lineReader = new BufferedReader(new FileReader("/Users/anushthan/Development/MTBS/MovieTicketBooking/src/Database/theatreInfo.csv"));

            String fileText;
            int i = 0;
            while((fileText = lineReader.readLine()) != null){
                i++;
                if(i == 1) continue;
                String[] data = fileText.split(",");
                String location = data[0].substring(1, data[0].length() - 1);
                String theatre = data[2].substring(1, data[2].length() - 1);

                pst.setString(1, location);
                pst.setInt(2, Integer.parseInt(data[1]));
                pst.setString(3, theatre);
                pst.setInt(4, Integer.parseInt(data[3]));
                pst.setInt(5, Integer.parseInt(data[4]));

                pst.executeUpdate();
            }
            System.out.println("Successfully refreshed theatreInfo");
            lineReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void movieInfo(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query = "insert into movieInfo values(?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(query);

            BufferedReader lineReader = new BufferedReader(new FileReader("/Users/anushthan/Development/MTBS/MovieTicketBooking/src/Database/movieInfo.csv"));

            String fileText;
            int i = 0;
            while((fileText = lineReader.readLine()) != null){
                i++;
                if(i == 1) continue;
                String[] data = fileText.split(",");
                String name = data[1].substring(1, data[1].length() - 1);
                String genre = data[3].substring(1, data[3].length() - 1);
                String lang = data[4].substring(1, data[4].length() - 1);


                pst.setInt(1, Integer.parseInt(data[0]));
                pst.setString(2, name);
                pst.setDouble(3, Double.parseDouble(data[2]));
                pst.setString(4, genre);
                pst.setString(5, lang);
                pst.setInt(6, Integer.parseInt(data[5]));
                pst.executeUpdate();
            }
            System.out.println("Successfully refreshed movieInfo");
            lineReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
