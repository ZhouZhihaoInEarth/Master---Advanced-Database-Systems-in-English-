import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfigTest {
    public static void main(String[] args) {
        DatabaseConfig config = new DatabaseConfig();

        Connection connection = null;

        try {
            Class.forName(config.getDriver());

            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());


            if (connection != null) {
                System.out.println("Connection successful!");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found" + e.getMessage());
            e.printStackTrace();



        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
            e.printStackTrace();



        } finally {


            if (connection != null) {
                try {
                    connection.close();


                } catch (SQLException e) {
                    e.printStackTrace();


                }
            }
        }
    }
}
