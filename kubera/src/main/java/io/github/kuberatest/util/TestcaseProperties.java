package io.github.kuberatest.util;

public class TestcaseProperties {
    private String webDriverFilePath = KuberaProperties.getProperty("webdriver.filepath");
    private String downloadDirectory = KuberaProperties.getProperty("download.directory");
    public String getWebDriverFilePath() {
        return webDriverFilePath;
    }

    public void setWebDriverFilePath(String value) {
        webDriverFilePath = value;
    }

    public String getDownloadDirectory() {
        return downloadDirectory;
    }

    public void setDownloadDirectory(String downloadDirectory) {
        this.downloadDirectory = downloadDirectory;
    }

    public boolean isChrome() {
        return KuberaProperties.getProperty("browser").equalsIgnoreCase("chrome");
    }

    public boolean isFirefox() {
        return KuberaProperties.getProperty("browser").equalsIgnoreCase("firefox");
    }

    public boolean isEdge() {
        return KuberaProperties.getProperty("browser").equalsIgnoreCase("edge");
    }
    public boolean isSafari() {
        return KuberaProperties.getProperty("browser").equalsIgnoreCase("safari");
    }

    public boolean isHeadless() {
        return KuberaProperties.getProperty("webdriver.headless").equalsIgnoreCase("true");
    }
    public boolean isAutoUpdate() {
        return KuberaProperties.getProperty("webdriver.update.auto").equalsIgnoreCase("true");
    }
}
