package SpatialData;

import oracle.spatial.geometry.JGeometry;
import org.locationtech.jts.geom.Geometry;

public class SpatialEntities {
    private int entitiesNumber;
    private String buildingName;
    private int buildingLayers;
    private String buildingState;
    private String buildingAttribute;
    private JGeometry geometry;

    // 构造函数
    public SpatialEntities(int entitiesNumber, String buildingName, int buildingLayers, String buildingState, String buildingAttribute, JGeometry geometry) {
        this.entitiesNumber = entitiesNumber;
        this.buildingName = buildingName;
        this.buildingLayers = buildingLayers;
        this.buildingState = buildingState;
        this.buildingAttribute = buildingAttribute;
        this.geometry = geometry;
    }
}