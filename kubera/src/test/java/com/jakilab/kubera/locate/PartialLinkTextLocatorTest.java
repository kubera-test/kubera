package com.jakilab.kubera.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class PartialLinkTextLocatorTest {
    @Test
    public void PartialLinkTextを指定したByクラスが作成されていること() {
        PartialLinkTextLocator partialLinkTextLocator = new PartialLinkTextLocator();
        By by = partialLinkTextLocator.by("partialLinkText");
        assertInstanceOf(By.ByPartialLinkText.class, by);
    }
}
