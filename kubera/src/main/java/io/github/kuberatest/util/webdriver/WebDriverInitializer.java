package io.github.kuberatest.util.webdriver;

import io.github.kuberatest.util.TestcaseProperties;
import org.openqa.selenium.WebDriver;

public interface WebDriverInitializer {
    void initializeSelenide(TestcaseProperties properties);
    WebDriver initializeSelenium(TestcaseProperties properties);
}
