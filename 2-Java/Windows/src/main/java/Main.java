import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateWindow window = new CreateWindow();
                window.setVisible(true);
            }
        });
    }


        /* Test .Properties file
        DatabaseConfig config = new DatabaseConfig();
        config.printDatabaseConfig();*/
    }


