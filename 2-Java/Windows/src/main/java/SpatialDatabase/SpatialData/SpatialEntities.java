package SpatialDatabase.SpatialData;

import oracle.spatial.geometry.JGeometry;

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

    public int getEntitiesNumber() {
        return entitiesNumber;
    }

    public void setEntitiesNumber(int entitiesNumber) {
        this.entitiesNumber = entitiesNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getBuildingLayers() {
        return buildingLayers;
    }

    public void setBuildingLayers(int buildingLayers) {
        this.buildingLayers = buildingLayers;
    }

    public String getBuildingState() {
        return buildingState;
    }

    public void setBuildingState(String buildingState) {
        this.buildingState = buildingState;
    }

    public String getBuildingAttribute() {
        return buildingAttribute;
    }

    public void setBuildingAttribute(String buildingAttribute) {
        this.buildingAttribute = buildingAttribute;
    }

    public JGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(JGeometry geometry) {
        this.geometry = geometry;
    }
}