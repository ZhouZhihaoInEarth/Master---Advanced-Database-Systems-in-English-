package ConfigSpatialDatabase;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

/* 读取和存储数据库连接的配置信息 */
public class DatabaseConfigure {
    private String driver;
    private String url;

    private String username;

    private String password;

    public DatabaseConfigure() {
        try (InputStream input = DatabaseConfigure.class.getClassLoader().getResourceAsStream("database.properties")) {
            Properties properties = new Properties();

            if (input == null) {
                System.out.println("Can't fine the properties value");
                return;
            }


            properties.load(input);

            this.driver = properties.getProperty("database.driver");
            this.url = properties.getProperty("database.url");
            this.username = properties.getProperty("database.username");
            this.password = properties.getProperty("database.password");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDriver(){
        return driver;
    }

    public String getUrl(){
        return url;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public void printDatabaseConfig() {
        System.out.println("Driver: " + getDriver());
        System.out.println("URL: " + getUrl());
        System.out.println("Username: " + getUsername());
        System.out.println("Password: " + getPassword());
    }


}
