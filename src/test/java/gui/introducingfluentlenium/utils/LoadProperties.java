package gui.introducingfluentlenium.utils;

import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    private Properties properties;

    public LoadProperties() {
        properties = loadProperties();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(LoadProperties.class.getResourceAsStream("/user.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;

    }

    public String getProperty (String property) {
        return properties.getProperty(property);
    }

}