package com.jakilab.kubera.locate;

import org.openqa.selenium.By;

public class PartialLinkTextLocator implements Locator {
    @Override
    public By by(String searchExpression) {
        return By.partialLinkText(searchExpression);
    }
}
