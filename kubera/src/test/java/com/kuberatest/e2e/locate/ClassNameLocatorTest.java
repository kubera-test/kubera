package com.kuberatest.e2e.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ClassNameLocatorTest {
    @Test
    public void classNameを指定したByクラスが作成されていること() {
        ClassNameLocator classNameLocator = new ClassNameLocator();
        By by = classNameLocator.by("className");
        assertInstanceOf(By.ByClassName.class, by);
    }
}
