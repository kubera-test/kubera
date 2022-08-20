package io.github.kuberatest.e2e.locate;

import org.openqa.selenium.By;

public class LinkTextLocator implements Locator {
    @Override
    public By by(String searchExpression) {
        return By.linkText(searchExpression);
    }
}
