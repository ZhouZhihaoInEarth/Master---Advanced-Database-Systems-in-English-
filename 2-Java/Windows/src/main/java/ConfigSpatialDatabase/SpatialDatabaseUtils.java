package ConfigSpatialDatabase;

import java.sql.*;

/*用于获取连接、执行查询以及关闭连接等数据库操作*/
public class SpatialDatabaseUtils {

    private static DatabaseConfigure databaseconfigure = new DatabaseConfigure();

    static {
        try {
            Class.forName(databaseconfigure.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseconfigure.getUrl(), databaseconfigure.getUsername(), databaseconfigure.getPassword());
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static ResultSet executeQuery(Connection conn, String query) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }
}
