package UserInterface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainWindow{
    @FXML
    private Button button_connection_db;




    @FXML
        public void database_ButtonClick(ActionEvent actionEvent)  {
        //try {
           // Connection connection = SpatialDatabaseUtils.getConnection();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connect to the Database");
            alert.setHeaderText("Prompt Message");
            alert.setContentText("Successful Connection!");
            alert.showAndWait();

       // } catch (SQLException e) {
          //  System.out.println("Connection Fail" + e.getMessage());

        }


    //}



}

