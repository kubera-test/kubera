package com.kuberatest.e2e.locate;

import org.openqa.selenium.By;

public class IdLocator implements Locator {

    @Override
    public By by(String searchExpression) {
        return By.id(searchExpression);
    }
}
