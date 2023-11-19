package SpatialDatabaseCURD;

import ConfigSpatialDatabase.DatabaseConfigure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteSpatialEntities {
    private final DatabaseConfigure connect_database;

    public DeleteSpatialEntities(DatabaseConfigure connect_database) {
        this.connect_database = connect_database;
    }

    public void DeleteEntity(int Entities_Number) {
        String sql = "DELETE FROM Residential_Area WHERE Entities_Number = ?";

        try (Connection connection = DriverManager.getConnection(connect_database.getUrl(), connect_database.getUsername(), connect_database.getPassword()); // 修正此处
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Entities_Number);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Entity Deleted Successfully: Entity Number " + Entities_Number);
            } else {
                System.out.println("No Entity Found with Entity Number: " + Entities_Number);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting entity: " + e.getMessage());
        }
    }

}