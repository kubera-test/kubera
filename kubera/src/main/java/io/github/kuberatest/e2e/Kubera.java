package io.github.kuberatest.e2e;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.kuberatest.e2e.action.ActionExecuter;
import io.github.kuberatest.util.TestcaseProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Kubera {

    private static TestcaseProperties properties = null;

    public void initialize() {
        properties = new TestcaseProperties();
        if (properties.isChrome()) {
            initializeChrome();
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

        ChromeOptions options = new ChromeOptions();
        if (properties.isHeadless()) {
            options.addArguments("--headless");
        }

        WebDriverRunner.setWebDriver(new ChromeDriver(options));
    }
}
