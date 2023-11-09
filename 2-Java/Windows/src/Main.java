import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main extends JFrame {
    private Connection connection;
    public Main() {
        this.setTitle("PDBe Project");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);

        // Delete Process
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Toolbar
        JToolBar toolBar = new JToolBar("Toolbar");

        // Toolbar Button
        toolBar.add(new JButton("Add Record"));
        toolBar.add(new JButton("Edit Record"));
        toolBar.add(new JButton("Delete Record"));
        toolBar.add(new JButton("View Record"));
        toolBar.add(new JButton("Search Record"));
        getContentPane().add(toolBar, BorderLayout.PAGE_START);

        initializeDBConnection();
    }

    private void initializeDBConnection() {
        try {
            String driver = System.getProperty("database.driver", "oracle.jdbc.driver.OracleDriver");
            String url    = System.getProperty("database.url","jdbc:oracle:thin:@//gort.fit.vutbr.cz:1521/orclpdb");
            String username = System.getProperty("database.username","xzhouz00");
            String password = System.getProperty("database.password","1175833801");

            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Successful connection");
        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(this, "Oracle JDBC driver not found.", "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + e.getMessage(), "Database Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }


    }
    public static void main (String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> {
            Main run = new Main();
            run.setVisible(true);
        });
    }
}
