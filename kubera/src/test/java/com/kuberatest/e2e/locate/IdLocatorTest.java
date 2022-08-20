package com.kuberatest.e2e.locate;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

public class IdLocatorTest {
    @Test
    public void idを指定したByクラスが作成されていること() {
        IdLocator idLocator = new IdLocator();
        By by = idLocator.by("id");
        assertInstanceOf(By.ById.class, by);
    }
}
