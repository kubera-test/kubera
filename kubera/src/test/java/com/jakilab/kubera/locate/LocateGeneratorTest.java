package com.jakilab.kubera.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class LocateGeneratorTest {
    @Test
    public void classNameを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ByClassName.class,
                LocateGenerator.getInstance().getLocator("class_name", ""));
    }
    @Test
    public void cssSelectorを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ByCssSelector.class,
                LocateGenerator.getInstance().getLocator("css_selector", ""));
    }
    @Test
    public void idを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ById.class,
                LocateGenerator.getInstance().getLocator("id", ""));
    }
    @Test
    public void linkTextを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ByLinkText.class,
                LocateGenerator.getInstance().getLocator("link_text", ""));
    }
    @Test
    public void nameを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ByName.class,
                LocateGenerator.getInstance().getLocator("name", ""));
    }
    @Test
    public void PartialLinkTextを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ByPartialLinkText.class,
                LocateGenerator.getInstance().getLocator("partial_link_text", ""));
    }
    @Test
    public void TagNameを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ByTagName.class,
                LocateGenerator.getInstance().getLocator("tag_name", "tag"));
    }
    @Test
    public void XPathを指定したByクラスが作成されていること() {
        assertInstanceOf(By.ByXPath.class,
                LocateGenerator.getInstance().getLocator("xpath", ""));
    }
}
