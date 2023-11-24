package UserInterface;
import ConfigSpatialDatabase.DatabaseConfigure;
import ConfigSpatialDatabase.SpatialDatabaseUtils;
import SpatialDatabaseCURD.QuerySpatialData;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;

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
    private TextArea output_text_area;
    public MainWindow(){
        DatabaseConfigure databaseConfigure = new DatabaseConfigure();
        this.query_spatial_data = new QuerySpatialData(databaseConfigure);
    }


    // 显示数据库状态的Label事件
    // 状态：已测试，没问题
    @FXML
    public void updateDatabaseStatus(boolean isConnected) {
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
    // 状态：已测试，没问题
    private void showAlert(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }


    // Button事件：查看数据库是否连接成功
    // 状态：已测试，没问题
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


    // Button事件：查看空间数据库中的表
    @FXML
    public void view_Database_Table_ButtonClick(ActionEvent actionEvent){
        String tableData = query_spatial_data.getAllTableDataFromDatabaseWithoutParameters();
        output_text_area.setText(tableData);


    }



}

