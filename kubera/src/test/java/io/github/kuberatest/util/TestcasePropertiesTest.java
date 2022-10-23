package io.github.kuberatest.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestcasePropertiesTest {
    private TestcaseProperties testcaseProperties;
    @BeforeEach
    public void setUp() {
        testcaseProperties = new TestcaseProperties();
    }

    @Test
    public void getWebdriverFilePath() {
        assertEquals("kubera\\webdriver\\old_version\\geckodriver.exe", testcaseProperties.getWebDriverFilePath());
    }

    @Test
    public void プロパティを上書きした場合getWebdriverFilePathの戻り値が変わること() {
        testcaseProperties.setWebDriverFilePath("webdriver\\geckodriver.exe");
        assertEquals("webdriver\\geckodriver.exe", testcaseProperties.getWebDriverFilePath());
    }
}
