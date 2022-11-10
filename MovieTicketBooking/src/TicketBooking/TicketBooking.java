package TicketBooking;

import javax.sound.midi.Soundbank;
import java.sql.*;
//import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.sql.CallableStatement;

public class TicketBooking implements  TicketBookingInterface{


    private String location;
    private String movie;
  //  private int date;
    private String theatre;
//    private String dimensional;
    private String Time_Slot;

    private int Number_of_Tickets;


    public TicketBooking(){
    }

    public TicketBooking(String location, String movie, String theatre , String TimeSlot) {
        this.location = location;
        this.movie = movie;
     this.theatre = theatre;
     this.Time_Slot = TimeSlot;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }


    public String getTheatre() {
        return theatre;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public String getTime_Slot() {
        return Time_Slot;
    }

    public void setTime_Slot(String time_Slot) {
        Time_Slot = time_Slot;
    }

    public int getNumber_of_Tickets() {
        return Number_of_Tickets;
    }

    public void setNumber_of_Tickets(int number_of_Tickets) {
        Number_of_Tickets = number_of_Tickets;
    }

    Scanner input = new Scanner(System.in);
    public void details()
   {
        Location();

   }
   public  void Location()
   {
       try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
           String query = "select Distinct Location from TheatreInfo;";

           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query);

           String print_location = "";
           System.out.println("Enter Location");
           while (rs.next()) {
                print_location = rs.getString("Location");
               System.out.println(print_location);
           }

           setLocation(input.nextLine());
           CheckLocation();


       } catch (Exception e){
           e.printStackTrace();
       }
   }

   public void CheckLocation()
   {
       try
       {
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");

           String query1 = "select Distinct Location from TheatreInfo where Location like'"+getLocation()+"'";
           Statement st1 = con.createStatement();
           ResultSet  rs1 = st1.executeQuery(query1);

           String CheckLocation = "";
           while (rs1.next())
           {
               CheckLocation = rs1.getString(1);
           }

            Scanner wer = new Scanner(System.in);
           if (Objects.equals(CheckLocation.compareToIgnoreCase(getLocation()), getLocation().compareToIgnoreCase(CheckLocation)))
           {
               Movie();
           }
           else {
               System.out.println("Location is Not Found, PLease Enter the Given Location");
           }
       } catch (Exception  e){
           e.printStackTrace();
       }
   }

    public  void Movie()
    {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select title from Movie;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter Movie Name");
            while (rs.next())
            {
                String Title = rs.getString("title").replace("_", " ");
                System.out.println(Title);
            }



            setMovie(input.nextLine().replace(" ", "_"));
            System.out.println(getMovie());
            CheckMovie();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void CheckMovie()
    {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query1 = "select title from Movie where title like'"+getMovie()+"';";
            Statement st1 = con.createStatement();
            ResultSet  rs1 = st1.executeQuery(query1);


            String CheckMovie = "";
            while (rs1.next())
            {
                CheckMovie = rs1.getString("title");
               //System.out.println(CheckMovie);
            }

         if (Objects.equals(CheckMovie.compareToIgnoreCase(getMovie()), getMovie().compareToIgnoreCase(CheckMovie)))
            {
               Theatre();
            }
            else {
                System.out.println("Movie is Not Found, PLease Enter the Given Movie");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }



    public  void Theatre()
    {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select Distinct Theatre from TheatreInfo where Location like '"+getLocation()+"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter Theatre Name");
            while (rs.next())
            {
                String lc = rs.getString(1);
                System.out.println(lc);
            }


            setTheatre(input.nextLine().replace(" ","_"));
            CheckTheatre();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void CheckTheatre()
    {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");

            String query1 = "select distinct Theatre from TheatreInfo where Theatre like '"+getTheatre()+"' ";
            Statement st1 = con.createStatement();
            ResultSet  rs1 = st1.executeQuery(query1);

            String CheckTheatre = "";
            while (rs1.next())
            {
                CheckTheatre = rs1.getString(1).replace(" ","_");

            }


            if (Objects.equals(CheckTheatre.compareToIgnoreCase(getTheatre()) ,getTheatre().compareToIgnoreCase(CheckTheatre)))
            {
                return;
              //  TimeSlot();

            }
            else {
                System.out.println("Theatre is Not Found, PLease Enter the Given Theatre");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void TimeSlot()
    {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select TimeSlot from Movie;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                String TimeSlot = rs.getString("TimeSlot");
                System.out.println(TimeSlot);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public  void NumberOfTickets()
    {
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "Update TheatreInfo set Number_of_Tickets = Number_of_Tickets - ? where Theatre = ? && ;";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1 , getNumber_of_Tickets());
            pst.setString(2, getTheatre());

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();

//            while (rs.next())
//            {
//                int Number_of_Tickets = rs.getInt("Number_of_Tickets");
//                System.out.println(Number_of_Tickets);
//            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void AddDetails() {

        details();




//        System.out.println("Enter Time Slot");
//        TimeSlot();
//        setTime_Slot(sc.next());
        
//        System.out.println("Enter the Number of Tickets");
//        setNumber_of_Tickets(sc.nextInt());


    }


    }
