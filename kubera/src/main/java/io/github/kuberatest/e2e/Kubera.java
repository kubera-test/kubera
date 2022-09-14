package io.github.kuberatest.e2e;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.kuberatest.e2e.action.ActionExecuter;
import io.github.kuberatest.util.TestcaseProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public class Kubera {

    private static TestcaseProperties properties = null;

    public void initialize() {
        properties = new TestcaseProperties();
        if (properties.isChrome()) {
            initializeChrome();
        } else if (properties.isFirefox()) {
            initializeFirefox();
        } else if (properties.isEdge()) {
            initializeEdge();
        }
    }

    public void action(String actionJson) {
        ActionExecuter.getInstance().execute(actionJson);
    }

    public void close() {
        properties = null;
        Selenide.closeWebDriver();
    }

    public static TestcaseProperties getProperties() {
        if (properties == null) {
            // TODO: 例外処理
            throw new RuntimeException("Kubera is not initialized");
        }
        return properties;
    }

    private void initializeChrome() {
        Configuration.browser = Browsers.CHROME;
//        System.setProperty("webdriver.chrome.driver", properties.getWebDriverFilePath());
        WebDriverManager.chromedriver().setup();

        // https://sites.google.com/a/chromium.org/chromedriver/capabilities
        ChromeOptions options = new ChromeOptions();
        if (properties.isHeadless()) {
            options.addArguments("--headless");
        }

        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", properties.getDownloadDirectory());
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    private void initializeFirefox() {
        Configuration.browser = Browsers.FIREFOX;
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        if (properties.isHeadless()) {
            options.addArguments("--headless");
        }

        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", properties.getDownloadDirectory());
//        profile.setPreference("browser.download.useDownloadDir", true);
//        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
//        profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
//        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//        profile.setPreference("browser.download.manager.showWhenStarting", false);
//        profile.setPreference("browser.download.manager.focusWhenStarting", false);
//        profile.setPreference("browser.download.manager.useWindow", false);
//        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
//        profile.setPreference("browser.download.manager.closeWhenDone", false);
//        profile.setPreference("pdfjs.disabled", true);
        options.setProfile(profile);

        WebDriverRunner.setWebDriver(new FirefoxDriver(options));
    }

    private void initializeEdge() {
        Configuration.browser = Browsers.EDGE;
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();
        if (properties.isHeadless()) {
            options.addArguments("--headless");
        }

        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", properties.getDownloadDirectory());
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        WebDriverRunner.setWebDriver(new EdgeDriver(options));
    }
}
