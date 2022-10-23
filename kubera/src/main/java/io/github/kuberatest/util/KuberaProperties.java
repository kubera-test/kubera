package io.github.kuberatest.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

public class KuberaProperties {

    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(
                    new URLClassLoader(
                            new URL[]{KuberaProperties.class.getResource("/")})
                            .getResourceAsStream("kubera.properties"));
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
