import ConfigSpatialDatabase.DatabaseConfigure;
import SpatialDatabaseCURD.DeleteSpatialEntities;
import SpatialDatabaseCURD.InsertSpatialEntities;
import SpatialDatabaseCURD.QuerySpatialData;
import SpatialDatabaseCURD.UpdateSpatialEntity;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {



    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        stage.setTitle("PDBe Project");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}







