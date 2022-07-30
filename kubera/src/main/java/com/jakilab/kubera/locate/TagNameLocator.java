package com.jakilab.kubera.locate;

import org.openqa.selenium.By;

public class TagNameLocator implements Locator {
    @Override
    public By by(String searchExpression) {
        return By.tagName(searchExpression);
    }
}
