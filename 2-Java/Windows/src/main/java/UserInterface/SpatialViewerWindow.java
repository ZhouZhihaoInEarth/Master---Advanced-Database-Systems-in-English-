package UserInterface;
import javax.swing.*;



public class SpatialViewerWindow extends JFrame{

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Spatial Data Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        SpatialDataPanel panel = new SpatialDataPanel();
        frame.add(panel);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}