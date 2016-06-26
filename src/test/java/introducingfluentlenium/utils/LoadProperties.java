package introducingfluentlenium.utils;

import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public static String loadProperty(String property) {
        Properties properties = new Properties();
        try {
            properties.load(LoadProperties.class.getResourceAsStream("/user.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(property);

    }

}