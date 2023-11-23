package UserInterface;

import ConfigSpatialDatabase.SpatialDatabaseUtils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;

public class MainWindow {


    @FXML
    private Button button_connection_database;
    @FXML
    private Label database_status;
    @FXML
    private ComboBox<String> spatialdatabase_combobox;


    // 显示数据库状态的Label事件
    @FXML
    public void update_Database_Status(boolean isConnected) {
        Platform.runLater(() -> {
            if (isConnected) {
                database_status.setText("Connected");
                database_status.setStyle("-fx-text-fill: red;");
            } else {
                database_status.setText("Not Connected");
                database_status.setStyle("-fx-text-fill: yellow;");
            }
        });
    }

    // 弹窗警报类
    private void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Button事件
    @FXML
    public void database_ButtonClick(ActionEvent actionEvent) {
        // 连接成功的话，提示：Successful Connection

        if (SpatialDatabaseUtils.isDatabaseConnected()){

            update_Database_Status(true);

            showAlert("Connect to the Database", "Prompt Message", "Successful Connection!", Alert.AlertType.INFORMATION);
      } else {
        // 连接失败的话，提示：Connection Fail!

            update_Database_Status(false);

            showAlert("Connect to the Database", "Prompt Message", "Connection Fail!", Alert.AlertType.INFORMATION);
      }

}




}

