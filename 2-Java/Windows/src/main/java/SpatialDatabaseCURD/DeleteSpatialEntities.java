package SpatialDatabaseCURD;

import ConfigSpatialDatabase.SpatialDatabaseUtils;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static Auxiliary.AlertUtil.showAlert;

public class DeleteSpatialEntities {

    public static void deleteEntity(String selectedTableName, int Entities_Number) {

        String sql = "DELETE FROM " + selectedTableName + " WHERE Entities_Number = ?";

        try (Connection connection = SpatialDatabaseUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             preparedStatement.setInt(1, Entities_Number);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                showAlert("Reminder", "Prompt Message", "Entity Deleted Successfully", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Warning", "Prompt Message", "No Entity Found in + selected table", Alert.AlertType.INFORMATION);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting entity from " + selectedTableName + ": " + e.getMessage());
        }
    }
}