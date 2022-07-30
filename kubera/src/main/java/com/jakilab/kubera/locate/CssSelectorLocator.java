package com.jakilab.kubera.locate;

import org.openqa.selenium.By;

public class CssSelectorLocator implements Locator {
    @Override
    public By by(String searchExpression) {
        return By.cssSelector(searchExpression);
    }
}
