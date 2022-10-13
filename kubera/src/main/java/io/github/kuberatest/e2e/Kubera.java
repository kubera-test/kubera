package io.github.kuberatest.e2e;

import com.codeborne.selenide.Selenide;
import io.github.kuberatest.e2e.action.ActionExecuter;
import io.github.kuberatest.util.TestcaseProperties;
import io.github.kuberatest.util.webdriver.WebDriverHelperFactory;
import io.github.kuberatest.util.webdriver.WebDriverInitializer;

public class Kubera {

    private static TestcaseProperties properties = null;

    public void initialize() {
        properties = new TestcaseProperties();
        WebDriverInitializer initializer = WebDriverHelperFactory.getInstance().createWebDriverInitializer(properties);
        initializer.initializeSelenide(properties);
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
}
