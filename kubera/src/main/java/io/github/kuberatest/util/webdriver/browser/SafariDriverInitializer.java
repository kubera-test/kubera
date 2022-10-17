package io.github.kuberatest.util.webdriver.browser;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.kuberatest.util.TestcaseProperties;
import io.github.kuberatest.util.webdriver.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariDriverInitializer implements WebDriverInitializer {

    @Override
    public void initializeSelenide(TestcaseProperties properties) {
        Configuration.browser = Browsers.SAFARI;
        Configuration.timeout = 10000;

        setupDriver(properties);
        SafariOptions options = createOptions(properties);

        WebDriverRunner.setWebDriver(new SafariDriver(options));
    }

    @Override
    public WebDriver initializeSelenium(TestcaseProperties properties) {
        setupDriver(properties);
        return new SafariDriver();
    }

    private void setupDriver(TestcaseProperties properties) {
        if(properties.isAutoUpdate()) {
            WebDriverManager.safaridriver().setup();
        } else {
            System.setProperty("webdriver.safari.driver", properties.getWebDriverFilePath());
        }
    }

    private SafariOptions createOptions(TestcaseProperties properties) {
        SafariOptions options = new SafariOptions();

        return options;
    }
}
