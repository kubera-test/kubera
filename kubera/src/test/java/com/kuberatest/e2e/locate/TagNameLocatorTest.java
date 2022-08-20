package com.kuberatest.e2e.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TagNameLocatorTest {
    @Test
    public void TagNameを指定したByクラスが作成されていること() {
        TagNameLocator tagNameLocator = new TagNameLocator();
        By by = tagNameLocator.by("tagName");
        assertInstanceOf(By.ByTagName.class, by);
    }
}
