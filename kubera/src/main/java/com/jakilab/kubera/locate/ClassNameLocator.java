package com.jakilab.kubera.locate;

import org.openqa.selenium.By;

public class ClassNameLocator implements Locator {
    @Override
    public By by(String searchExpression) {
        return By.className(searchExpression);
    }
}
