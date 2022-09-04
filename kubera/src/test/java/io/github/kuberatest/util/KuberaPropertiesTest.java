package io.github.kuberatest.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KuberaPropertiesTest {
    @Test
    public void getWebdriverFileName() {
        assertEquals("webdriver\\chromedriver.exe", KuberaProperties.getProperty("webdriver.filepath"));
    }
}
