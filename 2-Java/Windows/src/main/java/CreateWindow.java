import javax.swing.*;
import java.awt.*;


public class CreateWindow extends JFrame{

    public CreateWindow() {
        this.setTitle("PDBe Project");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);

        // Delete Process
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Toolbar
        JToolBar toolBar = new JToolBar("Toolbar");

        // Toolbar Button
        toolBar.add(new JButton("Upload the ESRI Shapefile"));
        toolBar.add(new JButton("Edit Record"));
        toolBar.add(new JButton("Delete Record"));
        toolBar.add(new JButton("View Record"));
        toolBar.add(new JButton("Search Record"));
        getContentPane().add(toolBar, BorderLayout.PAGE_START);

    }

}
