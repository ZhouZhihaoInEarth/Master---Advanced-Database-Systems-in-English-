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

    public static void closeConnection(AutoCloseable... resources) {
        for (AutoCloseable resource : resources) {
            if (resource != null) {
                try {
                    resource.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ResultSet executeQuery(Connection connection, String query) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            closeConnection(rs, pstmt, conn);
            return null;
        }
    }

    public static boolean isDatabaseConnected() {
        try (Connection connection = getConnection()) {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



}