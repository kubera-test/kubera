package io.github.kuberatest.util.webdriver;

import io.github.kuberatest.util.TestcaseProperties;
import io.github.kuberatest.util.webdriver.browser.ChromeDriverInitializer;
import io.github.kuberatest.util.webdriver.browser.EdgeDriverInitializer;
import io.github.kuberatest.util.webdriver.browser.FirefoxDriverInitializer;

public class WebDriverHelperFactory {
    private static WebDriverHelperFactory instance;
    
    public synchronized static WebDriverHelperFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverHelperFactory();
        }
        return instance;
    }
    
    public WebDriverInitializer createWebDriverInitializer(TestcaseProperties testcaseProperties) {
        if (testcaseProperties.isChrome()) {
            return new ChromeDriverInitializer();
        } else if (testcaseProperties.isFirefox()) {
            return new FirefoxDriverInitializer();
        } else if (testcaseProperties .isEdge()) {
            return new EdgeDriverInitializer();
        } else {
            // TODO: throw exception
            return null;
        }
    }
}
