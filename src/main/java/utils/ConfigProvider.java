package utils;

import java.io.IOException;
import java.util.Properties;

public final class ConfigProvider {

    private static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();

    public static final String BROWSER = prop.getProperty("browser");
    public static final String MAIN_URL = prop.getProperty("main.url");
    public static final int IMPLICITLY_WAIT = Integer.parseInt(prop.getProperty("implicitly.wait"));

    private ConfigProvider(){
    }

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties file " + CONFIG_PATH);
        }
        return properties;
    }
}

