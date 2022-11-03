import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        try{
            String query = "show databases;";
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "admin", "Project@112");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);


            while( rs.next()) {
                String databases = rs.getString(1);
                System.out.println(databases);
            }
            st.close();
            con.close();
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
