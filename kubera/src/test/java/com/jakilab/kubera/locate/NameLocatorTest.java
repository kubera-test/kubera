package com.jakilab.kubera.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class NameLocatorTest {
    @Test
    public void nameを指定したByクラスが作成されていること() {
        NameLocator nameLocator = new NameLocator();
        By by = nameLocator.by("name");
        assertInstanceOf(By.ByName.class, by);
    }
}
