import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOracleTable {
    private final DatabaseConfig connect_database;

    public CreateOracleTable(DatabaseConfig connect_database) {
        this.connect_database = connect_database;
    }

    public void CreateTable() {
        String sql = "CREATE TABLE Residential_Area (" +
                "  Entities_Number    NUMBER," +
                "  Building_Name      VARCHAR2(32)," +
                "  Building_Layers    NUMBER," +
                "  Building_State     VARCHAR2(32)," +
                "  Building_Attribute VARCHAR2(32)," +
                "  Geometry           SDO_GEOMETRY" +
                ")";
        try {
            Connection connection = DriverManager.getConnection(connect_database.getUrl(), connect_database.getUsername(), connect_database.getPassword());
            Statement statement = connection.createStatement();
            {
                statement.execute(sql);
                System.out.println("Table Created Successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error Creating Table: " + e.getMessage());
        }
    }

}
