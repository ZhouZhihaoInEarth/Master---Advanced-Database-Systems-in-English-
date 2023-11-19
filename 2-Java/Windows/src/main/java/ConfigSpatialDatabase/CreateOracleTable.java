package ConfigSpatialDatabase;

import ConfigSpatialDatabase.DatabaseConfigure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOracleTable {
    private final DatabaseConfigure connect_database;

    public CreateOracleTable(DatabaseConfigure connect_database) {
        this.connect_database = connect_database;
    }



    public void CreateTable() {
        String sql = "CREATE TABLE Residential_Area (" +
                "  Entities_Number    NUMBER," +
                "  Building_Name      VARCHAR2(32)," +
                "  Building_Layers    NUMBER," +
                "  Building_State     VARCHAR2(32)," +
                "  Building_Attribute VARCHAR2(32)," +
                "  Geometry           SDO_GEOMETRY" +
                ")";

        String sridSql = "INSERT INTO user_sdo_geom_metadata (table_name, column_name, srid, diminfo) VALUES ('RESIDENTIAL_AREA', 'GEOMETRY', 4326, SDO_DIM_ARRAY(SDO_DIM_ELEMENT('LONG', -180, 180, 0.5), SDO_DIM_ELEMENT('LAT', -90, 90, 0.5)))";

        try {
            Connection connection = DriverManager.getConnection(connect_database.getUrl(), connect_database.getUsername(), connect_database.getPassword());
            Statement statement = connection.createStatement();
            {
                statement.execute(sql);
                System.out.println("Table Created Successfully!");
                statement.execute(sridSql);
                System.out.println("SRID for WGS 84 (EPSG:4326) set successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error Creating Table: " + e.getMessage());
        }
    }

}
