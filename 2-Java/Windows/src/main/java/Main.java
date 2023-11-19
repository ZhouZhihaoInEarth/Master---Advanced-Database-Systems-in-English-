import ConfigSpatialDatabase.DatabaseConfigure;
import SpatialDatabaseCURD.DeleteSpatialEntities;
import SpatialDatabaseCURD.InsertSpatialEntities;
import SpatialDatabaseCURD.QuerySpatialData;
import SpatialDatabaseCURD.UpdateSpatialEntity;
import UserInterface.SpatialViewerWindow;


public class Main {

    public static void main(String[] args) {

        /*Initializing the Connection Database*/
        DatabaseConfigure connect_database = new DatabaseConfigure();
        InsertSpatialEntities insert = new InsertSpatialEntities(connect_database);
        DeleteSpatialEntities delete = new DeleteSpatialEntities(connect_database);
        UpdateSpatialEntity update = new UpdateSpatialEntity(connect_database);
        QuerySpatialData fetcher = new QuerySpatialData(connect_database);




            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    SpatialViewerWindow window = new SpatialViewerWindow();
                    window.setVisible(true);
                }
            });
        }

        /* Create Spatial Table
        ConfigSpatialDatabase.CreateOracleTable spatialtable = new ConfigSpatialDatabase.CreateOracleTable(connect_database);
        spatialtable.CreateTable();*/




        /*Insert the Spatial Entity*/
        //insert.InsertEntity(1, "Building A", 5, "New", "Residential", "POINT (1 2)");
        //insert.InsertEntity(2, "Park XYZ", 0, "Old", "Public Space", "POLYGON ((3 4, 5 6, 7 8, 9 10, 3 4))");
        //insert.InsertEntity(1, "Beijing to Paris", 0, "Active", "Park", "LINESTRING (116.4074 39.9042, 2.2945 48.8584)");


        /*Delete the Spatial Entity*/
        //delete.DeleteEntity(1);
        //delete.DeleteEntity(2);

        /*Update the Spatial Entity*/
        //update.updateEntity(1, "New Building Name", 10, "Renovated", "Commercial", "New SDO_GEOMETRY String");




    }







