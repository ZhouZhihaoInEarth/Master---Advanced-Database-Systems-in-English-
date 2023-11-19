import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        /*Initializing the Connection Database*/
        DatabaseConfig connect_database = new DatabaseConfig();
        InsertSpatialEntities insert = new InsertSpatialEntities(connect_database);
        DeleteSpatialEntities delete = new DeleteSpatialEntities(connect_database);
        UpdateSpatialEntity update = new UpdateSpatialEntity(connect_database);
        VisualizationSpatialData visual = new VisualizationSpatialData();






        /* Create Spatial Table
        CreateOracleTable dbTable = new CreateOracleTable(dbConfig);
        dbTable.CreateTable();
        */



        /*Insert the Spatial Entity*/
        insert.InsertEntity(1, "Building A", 5, "New", "Residential", "POINT (1 2)");
        insert.InsertEntity(2, "Park XYZ", 0, "Old", "Public Space", "POLYGON ((3 4, 5 6, 7 8, 9 10, 3 4))");



        /*Delete the Spatial Entity*/
        //delete.DeleteEntity(1);
        //delete.DeleteEntity(2);

        /*Update the Spatial Entity*/
        update.updateEntity(1, "New Building Name", 10, "Renovated", "Commercial", "New SDO_GEOMETRY String");

        // 显示地图
        visual.showMap();



//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                CreateWindow window = new CreateWindow();
//                window.setVisible(true);
//            }
//        });
    }



    }


