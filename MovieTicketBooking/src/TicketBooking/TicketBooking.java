
package TicketBooking;

import java.sql.*;
import java.util.*;

public class TicketBooking{

    private HashMap<Integer, String> loc = new HashMap<>();
    private int location;
    private int movie;
    private int theatre;
    private int timeSlot;
    private int numberOfTickets;


    public TicketBooking() {
    }

    public TicketBooking(int location, int movie, int theatre, int timeSlot) {
        this.location = location;
        this.movie = movie;
        this.theatre = theatre;
        this.timeSlot = timeSlot;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getMovie() {
        return movie;
    }

    public void setMovie(int movie) {
        this.movie = movie;
    }


    public int getTheatre() {
        return theatre;
    }

    public void setTheatre(int theatre) {
        this.theatre = theatre;
    }

    public int getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(int timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }


    public void getAllLocations() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select Distinct location from TheatreInfo;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter Location Number");
            int i = 1;
            while (rs.next()) {

                String print_location = rs.getString("location");
                loc.put(i, print_location);
                i++;
                System.out.println(i - 1+"." + " " + print_location);

            }

            Scanner sc = new Scanner(System.in);

            setLocation(sc.nextInt());
            checkLocation();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void checkLocation() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");

            String query1 = "select Distinct location from TheatreInfo where location like'" + loc.get(getLocation()) + "'";
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);

            String CheckLocation = "";
            while (rs1.next()) {
                CheckLocation = rs1.getString(1);
            }

            if (CheckLocation.equalsIgnoreCase(loc.get(getLocation()))) {

                getAllMovies();
            } else {
                System.out.println("Location is Not Found, PLease Enter the Given Location");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllMovies() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select movie_id , movie_name from MovieInfo;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter Movie_ID");
            System.out.println("Movie_ID   Movie_Name");

            while (rs.next()) {

                String Title = rs.getString(2).replace("_", " ");
                int MovieID = rs.getInt(1);
                System.out.println(MovieID + "." + "  \t\t" + Title);
            }

            Scanner sc = new Scanner(System.in);
            setMovie(sc.nextInt());
            checkMovie();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkMovie() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");


            String query1 = "select movie_id from movieInfo where movie_id like'" + getMovie() + "';";
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);


            int CheckMovie = 0;
            while (rs1.next()) {
                CheckMovie = rs1.getInt("movie_id");

            }

            if (getMovie() == CheckMovie) {
                getAllTheatre();
            } else {
                System.out.println("Movie is Not Found, PLease Enter the Given Movie");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void getAllTheatre() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select Distinct theatre_id  , theatre from TheatreInfo where location like '" + loc.get(getLocation()) + "'";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("Enter Theatre ID");
            System.out.println("Theatre_ID     Theatre");
            while (rs.next()) {
                int theatre_id = rs.getInt(1);
                String theatre = rs.getString("theatre").replace("_", " ");


                System.out.println(theatre_id + "." + "\t   " + theatre);
            }

            Scanner sc = new Scanner(System.in);
            setTheatre(sc.nextInt());
            checkTheatre();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkTheatre() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");

            String query1 = "select distinct theatre_id from TheatreInfo where theatre_id like '" + getTheatre() + "' ";
            Statement st1 = con.createStatement();
            ResultSet rs1 = st1.executeQuery(query1);

            int CheckTheatre = 0;
            while (rs1.next()) {
                CheckTheatre = rs1.getInt("theatre_id");

            }

            if (CheckTheatre == getTheatre()) {
                getAllTimeSlots();
            } else {
                System.out.println("Theatre is Not Found, PLease Enter the Given Theatre");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    HashMap<Integer, String> Time = new HashMap<>();

    public void getAllTimeSlots() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "select time_Slot from bookinginfo;";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            int i = 1;
            System.out.println("Enter Time Slot Number");

            while (rs.next()) {
                String TimeSlot = rs.getString("time_slot");
                Time.put(i, TimeSlot);
                i++;
                System.out.println(i - 1 +"."+ " " + TimeSlot);
            }
            Scanner sc = new Scanner(System.in);
            setTimeSlot(sc.nextInt());
            checkTimeSlot();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkTimeSlot() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "Select time_Slot from BookingInfo where time_Slot like '" + Time.get(getTimeSlot()) + "';";


            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            String timeSlot = "";
            while (rs.next()) {
                timeSlot = rs.getString("time_slot");
            }

            if (timeSlot.equalsIgnoreCase(Time.get(getTimeSlot()))) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the Number of Tickets");
                setNumberOfTickets(sc.nextInt());
                NumberOfTickets();
            }
            else {
                System.out.println("Please choose the given time slot");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void NumberOfTickets() {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            String query = "Update TheatreInfo set No_of_Tickets = No_of_Tickets - ? where theatre_id like ? && screen like ? ;";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, getNumberOfTickets());
            pst.setInt(2, getTheatre());
            pst.setInt(3, getMovie());
            pst.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startBooking() {
        getAllLocations();
    }
}

