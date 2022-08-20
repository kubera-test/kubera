package com.kuberatest.e2e.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CssSelectorLocatorTest {
    @Test
    public void cssSelectorを指定したByクラスが作成されていること() {
        CssSelectorLocator cssSelectorLocator = new CssSelectorLocator();
        By by = cssSelectorLocator.by("cssSelector");
        assertInstanceOf(By.ByCssSelector.class, by);
    }
}
