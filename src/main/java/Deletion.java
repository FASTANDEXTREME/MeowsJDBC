import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;

public class Deletion {
    void delete(){
        Scanner scanner= new Scanner(System.in);
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        System.out.print("Enter the ID of employee:");
        int empid = scanner.nextInt();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement("DELETE FROM employee WHERE emp_id = ?")) {
            System.out.println("Connected to the database.");
            ps.setInt(1, empid);
            int rows= ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Record deleted successfully");
            } else {
                System.out.println("No employee found with given ID");
            }


        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
