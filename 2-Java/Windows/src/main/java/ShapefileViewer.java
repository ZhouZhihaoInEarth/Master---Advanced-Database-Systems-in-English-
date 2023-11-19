import org.geotools.api.data.FileDataStore;
import org.geotools.api.data.FileDataStoreFinder;
import org.geotools.api.data.SimpleFeatureSource;
import org.geotools.api.style.Style;
import org.geotools.map.*;
import org.geotools.styling.SLD;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;

import java.io.File;

public class ShapefileViewer {

    public static void main(String[] args) throws Exception {
        // 选择Shapefile
        File file = JFileDataStoreChooser.showOpenFile("shp", null);
        if (file == null) {
            System.out.println("Failed to open");
            return;
        }

        // Read the Shapefile
        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        // Create the map, and add the layer
        MapContent map = new MapContent();
        map.setTitle("Shapefile Viewer");
        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(featureSource, style);
        map.addLayer(layer);

        // Show map
        JMapFrame.showMap(map);
    }
}