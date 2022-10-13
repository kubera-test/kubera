package io.github.kuberatest.util.webdriver.browser;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.kuberatest.util.TestcaseProperties;
import io.github.kuberatest.util.webdriver.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class EdgeDriverInitializer implements WebDriverInitializer {

    @Override
    public void initializeSelenide(TestcaseProperties properties) {
        Configuration.browser = Browsers.EDGE;

        setupDriver(properties);
        EdgeOptions options = createOptions(properties);

        WebDriverRunner.setWebDriver(new EdgeDriver(options));
    }

    @Override
    public WebDriver initializeSelenium(TestcaseProperties properties) {
        setupDriver(properties);
        return new EdgeDriver();
    }

    private void setupDriver(TestcaseProperties properties) {
        if(properties.isAutoUpdate()) {
            WebDriverManager.edgedriver().setup();
        } else {
            System.setProperty("webdriver.edge.driver", properties.getWebDriverFilePath());
        }
    }

    private EdgeOptions createOptions(TestcaseProperties properties) {
        EdgeOptions options = new EdgeOptions();
        if (properties.isHeadless()) {
            options.addArguments("--headless");
        }

        Map<String, Object> prefs = new HashMap<>();
//        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", properties.getDownloadDirectory());
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        return options;
    }
}
