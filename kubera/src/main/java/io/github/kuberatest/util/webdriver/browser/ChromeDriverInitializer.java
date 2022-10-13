package io.github.kuberatest.util.webdriver.browser;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.kuberatest.util.TestcaseProperties;
import io.github.kuberatest.util.webdriver.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverInitializer implements WebDriverInitializer {

    @Override
    public void initializeSelenide(TestcaseProperties properties) {
        Configuration.browser = Browsers.CHROME;

        setupDriver(properties);
        ChromeOptions options = createOptions(properties);

        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }

    @Override
    public WebDriver initializeSelenium(TestcaseProperties properties) {
        setupDriver(properties);
        return new ChromeDriver();
    }

    private void setupDriver(TestcaseProperties properties) {
        if(properties.isAutoUpdate()) {
            WebDriverManager.chromedriver().setup();
        } else {
            System.setProperty("webdriver.chrome.driver", properties.getWebDriverFilePath());
        }
    }

    private ChromeOptions createOptions(TestcaseProperties properties) {
        ChromeOptions options = new ChromeOptions();
        if (properties.isHeadless()) {
            options.addArguments("--headless");
        }

        // https://sites.google.com/a/chromium.org/chromedriver/capabilities
        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", properties.getDownloadDirectory());
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        return options;
    }
}
