import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;



public class Retrieval {


    void retrieve() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee")) {

             System.out.println("Connected to the database.");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Employee Records ---");

            while (rs.next()) {
                int id = rs.getInt("emp_id");
                String name = rs.getString("emp_name");
                int salary = rs.getInt("emp_sal");
                String city = rs.getString("emp_city");

                System.out.println(id + " | " + name + " | " + salary + " | " + city);
            }

        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
