package com.jakilab.kubera.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class LinkTextLocatorTest {
    @Test
    public void linkTextを指定したByクラスが作成されていること() {
        LinkTextLocator linkTextLocatorLocator = new LinkTextLocator();
        By by = linkTextLocatorLocator.by("linkText");
        assertInstanceOf(By.ByLinkText.class, by);
    }
}
