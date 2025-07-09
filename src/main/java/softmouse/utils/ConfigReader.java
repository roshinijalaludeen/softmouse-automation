package softmouse.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final Properties prop = new Properties();

    public ConfigReader() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }
}

