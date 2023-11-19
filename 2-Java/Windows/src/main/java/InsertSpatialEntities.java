import java.sql.*;

public class InsertSpatialEntities {
    private final DatabaseConfig connect_database;

    public InsertSpatialEntities(DatabaseConfig connect_database) {
        this.connect_database = connect_database;
    }

    public void InsertEntity(int entityNumber, String name, int layers, String state, String attribute, String wktGeometry) {
        String sql = "INSERT INTO Residential_Area (Entities_Number, Building_Name, Building_Layers, Building_State, Building_Attribute, Geometry) VALUES (?, ?, ?, ?, ?, SDO_GEOMETRY(?))";

        try (Connection connection = DriverManager.getConnection(connect_database.getUrl(), connect_database.getUsername(), connect_database.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, entityNumber);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, layers);
            preparedStatement.setString(4, state);
            preparedStatement.setString(5, attribute);
            preparedStatement.setString(6, wktGeometry);

            preparedStatement.executeUpdate();
            System.out.println("Entity Inserted Successfully: " + name);
        } catch (SQLException e) {
            System.out.println("Error inserting entity: " + e.getMessage());
        }
    }
}
