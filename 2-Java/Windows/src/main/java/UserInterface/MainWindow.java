package UserInterface;
import ConfigSpatialDatabase.DatabaseConfigure;
import ConfigSpatialDatabase.SpatialDatabaseUtils;
import SpatialDatabaseCURD.QuerySpatialData;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.util.List;

public class MainWindow {


    @FXML
    private Button button_connection_database;
    @FXML
    private  Button view_table_button;
    @FXML
    private Label database_status;
    @FXML
    private QuerySpatialData query_spatial_data;
    @FXML
    private ListView show_table_name;


    public MainWindow(){
        DatabaseConfigure databaseConfigure = new DatabaseConfigure();
        this.query_spatial_data = new QuerySpatialData(databaseConfigure);
    }




    /**
     * @ Description: Displays the database status in label form.
     * @ Control: Label
     * @ Control name: database_status
     * */
    @FXML
    public void updateDatabaseStatus(boolean isConnected) {
        Platform.runLater(() -> {
            if (isConnected) {
                database_status.setText("Connected");
                database_status.setStyle("-fx-text-fill: red;");
            } else {
                database_status.setText("Not Connected");
                database_status.setStyle("-fx-text-fill: black;");
            }
        });
    }





    /**
     * @ Description:  Alert
     * */
    private void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }





    /**
     * @ Description: Check whether the database is successfully connected.
     * @ Control: Button
     * @ Control name: button_connection_database
     * */
    @FXML
    public void databaseButtonClick(ActionEvent actionEvent) {


        if (SpatialDatabaseUtils.isDatabaseConnected()){

            updateDatabaseStatus(true);

            showAlert("Connect to the Database", "Prompt Message", "Successful Connection!", Alert.AlertType.INFORMATION);

      } else {
        // 连接失败的话，提示：Connection Fail!

            updateDatabaseStatus(false);

            showAlert("Connect to the Database", "Prompt Message", "Connection Fail!", Alert.AlertType.INFORMATION);
      }

}





    /**
     * @ Description: Check whether the database is successfully connected.
     * @ Control: Button
     * @ Control name: button_connection_database
     * */
    @FXML
    public void viewDatabaseTableNamesByButtonClick(ActionEvent actionEvent){
        List<String> tableNames = SpatialDatabaseUtils.getTableNames();
        ObservableList<String> items = show_table_name.getItems();
        items.clear();
        for (String tableName : tableNames){
            items.addAll(tableNames);
        }
    }



}

