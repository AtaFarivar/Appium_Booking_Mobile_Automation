package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    protected static final Properties CONFIG_PROP = new Properties();
    protected static final String PROPERTIES_FILE_PATH = "src/main/resources/config.properties";

    public PropertiesReader() {
    }

    public static String getProperty(String key) {
        try (FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
            CONFIG_PROP.load(fileInputStream);
        } catch (IOException ignored) {
        }
        return CONFIG_PROP.getProperty(key);
    }

    public static boolean isAndroid(){
        if (getProperty("platform").equals("Android")) {
            return true;
        }else {
            return false;
        }

    }


}
