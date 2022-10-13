package io.github.kuberatest.util.webdriver.browser;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.kuberatest.util.TestcaseProperties;
import io.github.kuberatest.util.webdriver.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FirefoxDriverInitializer implements WebDriverInitializer {

    @Override
    public void initializeSelenide(TestcaseProperties properties) {
        Configuration.browser = Browsers.FIREFOX;

        setupDriver(properties);
        FirefoxOptions options = createOptions(properties);

        WebDriverRunner.setWebDriver(new FirefoxDriver(options));
    }

    @Override
    public WebDriver initializeSelenium(TestcaseProperties properties) {
        setupDriver(properties);
        return new FirefoxDriver();
    }

    private void setupDriver(TestcaseProperties properties) {
        if(properties.isAutoUpdate()) {
            WebDriverManager.firefoxdriver().setup();
        } else {
            System.setProperty("webdriver.gecko.driver", properties.getWebDriverFilePath());
        }
    }

    private FirefoxOptions createOptions(TestcaseProperties properties) {
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

        return options;
    }
}
