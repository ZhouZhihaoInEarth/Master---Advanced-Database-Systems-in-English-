package SpatialData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConfigSpatialDatabase.SpatialDatabaseUtils;
import oracle.spatial.geometry.JGeometry;

public class SpatialDataReader {

    public static List<SpatialEntities> ReadData(String sql) {
        List<SpatialEntities> dataList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = SpatialDatabaseUtils.getConnection();

            //执行查询
            ResultSet resultSet = SpatialDatabaseUtils.executeQuery(connection, sql);

            while (resultSet.next()) {
                int entitiesNumber = resultSet.getInt("Entities_Number");
                String buildingName = resultSet.getString("Building_Name");
                int buildingLayers = resultSet.getInt("Building_Layers");
                String buildingState = resultSet.getString("Building_State");
                String buildingAttribute = resultSet.getString("Building_Attribute");
                JGeometry geometry = JGeometry.load(resultSet.getBytes("Geometry"));

                SpatialEntities data = new SpatialEntities(entitiesNumber, buildingName, buildingLayers, buildingState, buildingAttribute, geometry);
                dataList.add(data);
            }


        } catch (SQLException e) {
            e.printStackTrace();


        } catch (Exception e) {


            throw new RuntimeException(e);


        } finally {


            SpatialDatabaseUtils.closeConnection(connection);
        }

        return dataList;
    }
}