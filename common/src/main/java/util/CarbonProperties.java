package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CarbonProperties {
    private static CarbonProperties instance = new CarbonProperties();
    private static Properties properties;

    public static int TIME_FRAME_IN_NANOS = 16666666;
    public static int TIME_FRAME_IN_MILLIS = 16;
    public static float TIME_FRAME_IN_SECOND = 0.0166f;

    public static String SERVER_HOST = "server.host";
    public static String SERVER_PORT = "server.port";
    public static String FRAME_TIME = "frame.time";

    private CarbonProperties() {
        properties = new Properties();
        InputStream input = CarbonProperties.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
