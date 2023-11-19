package SpatialDatabaseCURD;

import ConfigSpatialDatabase.DatabaseConfigure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSpatialEntity {
    private final DatabaseConfigure connect_database;

    public UpdateSpatialEntity(DatabaseConfigure connect_database){
        this.connect_database = connect_database;
    }









    public void updateEntity(int entityNumber, String newName, int newLayers, String newState, String newAttribute, String newGeometry) {
        String sql = "UPDATE Residential_Area SET Building_Name = ?, Building_Layers = ?, Building_State = ?, Building_Attribute = ?, Geometry = SDO_GEOMETRY(?) WHERE Entities_Number = ?";
        try (Connection connection = DriverManager.getConnection(connect_database.getUrl(), connect_database.getUsername(), connect_database.getPassword());
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, newLayers);
            preparedStatement.setString(3, newState);
            preparedStatement.setString(4, newAttribute);
            preparedStatement.setString(5, newGeometry);
            preparedStatement.setInt(6, entityNumber);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Entity Updated Successfully: Entity Number " + entityNumber);
            } else {
                System.out.println("No Entity Found with Entity Number: " + entityNumber);
            }
        } catch (SQLException e) {
            System.out.println("Error updating entity: " + e.getMessage());
        }
    }
}



