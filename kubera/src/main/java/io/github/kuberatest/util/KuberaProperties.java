package io.github.kuberatest.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class KuberaProperties {

    private static final Properties properties;

    static {
        String envString = System.getProperty("testEnv", "");
        String propertiesFileName;
        if (envString.trim().length() == 0) {
            propertiesFileName = "kubera.properties";
        } else {
            propertiesFileName = String.format("kubera-%s.properties", envString);
        }

        properties = new Properties();
        try {
            properties.load(
                    new URLClassLoader(
                            new URL[]{KuberaProperties.class.getResource("/")})
                            .getResourceAsStream(propertiesFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
