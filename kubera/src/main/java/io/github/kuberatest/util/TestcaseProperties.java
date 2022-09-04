package io.github.kuberatest.util;

public class TestcaseProperties {
    private String webDriverFilePath = KuberaProperties.getProperty("webdriver.filepath");
    public String getWebDriverFilePath() {
        return webDriverFilePath;
    }

    public void setWebDriverFilePath(String value) {
        webDriverFilePath = value;
    }

    public boolean isChrome() {
        return KuberaProperties.getProperty("browser").equalsIgnoreCase("chrome");
    }

    public boolean isHeadless() {
        return KuberaProperties.getProperty("webdriver.headless").equalsIgnoreCase("true");
    }
}
