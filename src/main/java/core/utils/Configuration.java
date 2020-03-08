package core.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by majid on 5/23/17.
 */
public class Configuration {
    static private Properties configuration = null;

    public static void load() throws IOException {
        if (configuration != null)
            configuration = readFile();
    }

    public static Properties getProperties() {
        if (configuration == null) {
            try {
                configuration = readFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return configuration;
    }

    public static String getProperty(String key) {
        if (configuration == null || key == null) {
            try {
                configuration = readFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return configuration.getProperty(key);
    }


    public static long getConversationTimeout() {
        return Long.valueOf(getProperty("conversation.timeout"));
    }

    public static String getProperty(String key, String defaultValue) {
        if (configuration == null || key == null) {
            try {
                configuration = readFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return configuration.getProperty(key, defaultValue);
    }

    private static Properties readFile() throws IOException {

        Properties props = new Properties();
        try {
            ClassLoader loader = Configuration.class.getClassLoader();
            InputStream in = loader.getResourceAsStream("configuration/nejat.properties");
            props.load(in);
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
        return props;
    }
}
