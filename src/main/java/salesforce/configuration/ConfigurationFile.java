package salesforce.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads and gets the environment variables within properties file.
 */
public class ConfigurationFile {

    private static final String CONFIG_FILE_PATH = "config.properties";
    public static Properties CONFIG_PROPERTIES;

    static {
        try {
            CONFIG_PROPERTIES = readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets an object with all environment variables and their values within properties file.
     *
     * @return a property entity.
     */
    public static Properties readFile() throws IOException {
        Properties properties = new Properties();
        File file = new File(CONFIG_FILE_PATH);
        if (file.exists()) {
            InputStream reading = new FileInputStream(file);
            properties.load(reading);
        }
        return properties;
    }

    /**
     * Gets each value of the environment value from a configuration file.
     *
     * @param variable is the value to get from the environment variables.
     * @return the environment value.
     */
    public static String getEnvVariables(final String variable) {
        if (CONFIG_PROPERTIES.getProperty(variable) != null) {
            return CONFIG_PROPERTIES.getProperty(variable);
        }
        return System.getenv(variable);
    }
}
