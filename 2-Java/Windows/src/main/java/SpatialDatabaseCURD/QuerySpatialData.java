package SpatialDatabaseCURD;

import ConfigSpatialDatabase.DatabaseConfigure;
import ConfigSpatialDatabase.SpatialDatabaseUtils;

import java.sql.*;

/*
 * Connect to the database, execute the query, and process the returned spatial data.
 *
 * 连接到数据库、执行查询并处理返回的空间数据。
 */

public class QuerySpatialData {
    private DatabaseConfigure database_Config;

    public QuerySpatialData(DatabaseConfigure databaseconfig) {
        this.database_Config = databaseconfig;
    }

    public ResultSet getAllTableDataFromDatabaseWithParameters(String tableName) {
        String sql = "SELECT * FROM " + tableName;
        try {
            return SpatialDatabaseUtils.executeQuery(SpatialDatabaseUtils.getConnection(), sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getAllTableDataFromDatabaseWithoutParameters() {
        StringBuilder result = new StringBuilder();


        try (Connection connection = SpatialDatabaseUtils.getConnection();

             ResultSet tables_result_set = connection.getMetaData().getTables(null, null, "%", new String[]{"TABLE"})) {

            while (tables_result_set.next()) {
                String tableName = tables_result_set.getString(3);
                result.append("Table: ").append(tableName).append("\n");
                String query = "SELECT * FROM " + tableName;

                try (ResultSet resultSet = SpatialDatabaseUtils.executeQuery(connection, query)) {
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnCount = resultSetMetaData.getColumnCount();


                    while (resultSet != null && resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            String columnValue = resultSet.getString(i);
                            result.append(columnValue).append(" | ");
                        }
                        result.append("\n");
                    }
                    result.append("----------------------------------\n");

                } catch (SQLException e) {
                    result.append("Error in table: ").append(tableName).append(" - ").append(e.getMessage()).append("\n");
                }
            }
        } catch (SQLException e) {
            result.append("QueryData Connection Database Fail: ").append(e.getMessage()).append("\n");
        }
        return result.toString();
    }
}




