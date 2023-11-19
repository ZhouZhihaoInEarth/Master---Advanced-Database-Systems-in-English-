import org.geotools.map.MapContent;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.event.MapMouseEvent;
import org.geotools.swing.tool.CursorTool;

public class VisualizationSpatialData {
    private MapContent mapContent;

    public VisualizationSpatialData() {
        this.mapContent = new MapContent();
        mapContent.setTitle("Spatial Data Visualization");

    }

    public void showMap() {
        JMapFrame mapFrame = new JMapFrame(mapContent);
        mapFrame.enableToolBar(true);
        mapFrame.enableStatusBar(true);
        mapFrame.setSize(800, 600);
        mapFrame.setVisible(true);

        mapFrame.getMapPane().setCursorTool(new CursorTool() {
            @Override
            public void onMouseClicked(MapMouseEvent ev) {
                // 处理地图上的点击事件
            }
        });
    }
}
