package UserInterface;

import SpatialData.SpatialDataReader;
import SpatialData.SpatialEntities;
import oracle.spatial.geometry.JGeometry;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SpatialDataPanel extends JPanel {
    private List<SpatialEntities> spatialdata;

    public SpatialDataPanel(){
        spatialdata = SpatialDataReader.ReadData("SELECT * FROM Residential_Area");
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 在这里绘制空间数据
        for (SpatialEntities entity : spatialdata) {
            JGeometry geometry = entity.getGeometry();

            // 根据JGeometry类型绘制不同的几何形状
            switch (geometry.getType()) {
                case JGeometry.GTYPE_POINT:
                    drawPoint(geometry, g);
                    break;
                // 可以增加更多的几何类型处理
                // 如 JGeometry.GTYPE_POLYGON: drawPolygon(geometry, g); break;
            }
        }
    }
}
