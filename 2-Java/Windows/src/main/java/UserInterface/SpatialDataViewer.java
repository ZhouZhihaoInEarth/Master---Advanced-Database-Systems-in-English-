package UserInterface;
import ConfigSpatialDatabase.DatabaseConfigure;
import SpatialDatabase.SpatialData.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SpatialDataViewer {

    private final DatabaseConfigure connect_database;

    public SpatialDataViewer(DatabaseConfigure connect_database) {
        this.connect_database = connect_database;
    }

    public void showDataViewer() {
        // 创建主窗口
        JFrame frame = new JFrame("Spatial Data Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // 创建表格模型
        String[] columnNames = {"Entity Number", "Building Name", "Layers", "State", "Attribute", "Geometry"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // 加载 JDBC 驱动
        try {
            Class.forName(connect_database.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return; // 如果驱动加载失败，停止执行
        }

        // 从数据库读取数据并填充到表格模型
        try (Connection connection = DriverManager.getConnection(connect_database.getUrl(), connect_database.getUsername(), connect_database.getPassword())) {
            String sql = "SELECT * FROM Residential_Area";
            List<SpatialEntities> dataList = SpatialDataReader.ReadData(sql, connection);
            for (SpatialEntities entity : dataList) {
                tableModel.addRow(new Object[]{
                        entity.getEntitiesNumber(),
                        entity.getBuildingName(),
                        entity.getBuildingLayers(),
                        entity.getBuildingState(),
                        entity.getBuildingAttribute(),
                        entity.getGeometry() // 或转换为更适合显示的格式
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return; // 如果连接失败，停止执行
        }

        // 添加表格到滚动面板，并将其添加到主窗口
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // 显示窗口
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DatabaseConfigure connect_database = new DatabaseConfigure();
        SpatialDataViewer viewer = new SpatialDataViewer(connect_database);
        viewer.showDataViewer();
    }
}
