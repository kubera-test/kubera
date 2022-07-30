package com.jakilab.kubera.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class XPathLocatorTest {
    @Test
    public void XPathを指定したByクラスが作成されていること() {
        XPathLocator xPathLocator = new XPathLocator();
        By by = xPathLocator.by("xpath");
        assertInstanceOf(By.ByXPath.class, by);
    }
}
