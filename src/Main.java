import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/premiere?serverTimezone=UTC&useSSL=false","java","j83PsxTVk94RtyUW");
            System.out.println("Connection success!");

            Statement stmt=con.createStatement();
            String sql = "INSERT INTO customers " +
                    "VALUES (3, 'Czeslaw', 'Alojzy', 'Jakistam')";
            stmt.executeUpdate(sql);

            ResultSet rs=stmt.executeQuery("select * from customers");

            while (rs.next()) {
                System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4));
            }
            con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }
}
