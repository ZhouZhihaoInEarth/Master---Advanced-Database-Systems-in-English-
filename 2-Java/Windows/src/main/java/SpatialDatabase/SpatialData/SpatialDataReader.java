package SpatialDatabase.SpatialData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConfigSpatialDatabase.SpatialDatabaseUtils;
import oracle.spatial.geometry.JGeometry;
import oracle.sql.STRUCT;

public class SpatialDataReader {

    public static List<SpatialEntities> ReadData(String sql, Connection connection) {
        List<SpatialEntities> dataList = new ArrayList<>();
        Connection con = null;

        try {
            con = SpatialDatabaseUtils.getConnection();

            // 执行查询
            ResultSet resultSet = SpatialDatabaseUtils.executeQuery(con, sql);

            while (resultSet.next()) {
                int entitiesNumber = resultSet.getInt("Entities_Number");
                String buildingName = resultSet.getString("Building_Name");
                int buildingLayers = resultSet.getInt("Building_Layers");
                String buildingState = resultSet.getString("Building_State");
                String buildingAttribute = resultSet.getString("Building_Attribute");

                // 将 Oracle SQL STRUCT 转换为 JGeometry
                STRUCT st = (STRUCT) resultSet.getObject("Geometry");
                JGeometry geometry = JGeometry.load(st);

                SpatialEntities data = new SpatialEntities(entitiesNumber, buildingName, buildingLayers, buildingState, buildingAttribute, geometry);
                dataList.add(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SpatialDatabaseUtils.closeConnection();
        }

        return dataList;
    }
}