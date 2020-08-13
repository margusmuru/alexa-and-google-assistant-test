package csgoInventory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;
    private static PropertyReader instance = null;

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
            properties = getPropValues();
        }
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    private static Properties getPropValues() {
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            InputStream inputStream = PropertyReader.getInstance().getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            inputStream.close();
            return prop;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        return null;
    }
}
