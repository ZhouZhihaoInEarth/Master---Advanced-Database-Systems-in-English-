import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// 仅用来测试对数据库的增删改查
public class CreateOracleTableTest {
    public static void main(String[] args) {
        DatabaseConfig config = new DatabaseConfig();
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(config.getDriver());
            connection = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());

            String sql = "CREATE TABLE test_tables (" + "id INT PRIMARY KEY," + "name VARCHAR(50)," + "age INT)";

            statement = connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Table created successfully.");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("SQL error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}