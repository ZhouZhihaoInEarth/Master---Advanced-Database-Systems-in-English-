package SpatialDatabaseCURD;

import ConfigSpatialDatabase.DatabaseConfigure;

import javax.swing.*;
import java.sql.*;

/*
 * Connect to the database, execute the query, and process the returned spatial data.
 * 连接到数据库、执行查询并处理返回的空间数据。
 * */
public class QuerySpatialData extends JFrame {
    private DatabaseConfigure databaseconfig;

    public QuerySpatialData(DatabaseConfigure databaseconfig) {
        this.databaseconfig = databaseconfig;
    }

    public ResultSet fetchSpatialData(String tableName) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;

        try {
            Class.forName(databaseconfig.getDriver());
            connection = DriverManager.getConnection(databaseconfig.getUrl(), databaseconfig.getUsername(), databaseconfig.getPassword());
            statement = connection.createStatement();

            String sql = "SELECT * FROM " + tableName;
            resultset = statement.executeQuery(sql);

            return resultset;

        } catch (ClassNotFoundException e) {
            System.out.println("Database driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Database access error: " + e.getMessage());
        }

        return resultset;
    }
}



