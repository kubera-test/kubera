package com.jakilab.kubera.locate;

import org.openqa.selenium.By;

public class XPathLocator implements Locator {
    @Override
    public By by(String searchExpression) {
        return By.xpath(searchExpression);
    }
}
