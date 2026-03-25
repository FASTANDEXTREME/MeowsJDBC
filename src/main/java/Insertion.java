import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import io.github.cdimascio.dotenv.Dotenv;


public class Insertion {

    int num;
    int eid;
    String ename;
    int esalary;
    String ecity;

    void insert() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database.");

            System.out.print("How many Employee you have to Enter?:");
            num= scanner.nextInt();

            String sql = "INSERT INTO employee (emp_id, emp_name, emp_sal, emp_city) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            for(int i=1;i<=num;i++) {
                System.out.print("Enter Employee ID:");
                eid = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Employee Name:");
                ename = scanner.nextLine();
                System.out.print("Enter Employee Salary:");
                esalary = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Employee City:");
                ecity = scanner.nextLine();
                ps.setInt(1, eid);
                ps.setString(2, ename);
                ps.setInt(3, esalary);
                ps.setString(4, ecity);
                ps.executeUpdate();
                System.out.println("DONE!!");
            }
        }

        catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
            }

        }

}





