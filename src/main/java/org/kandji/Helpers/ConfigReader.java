package org.kandji.Helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties config;

    public ConfigReader() {
        config = new Properties();
        try (InputStream fis = ConfigReader.class.getClassLoader().getResourceAsStream("environment.properties")) {
            if (fis == null) {
                throw new IOException("Could not find environment.properties in resources folder");
            }
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return config.getProperty(key);
    }
}
