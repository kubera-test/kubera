package io.github.kuberatest.actiongenerate.writer.testcasewriter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface TestcaseElementWriter extends TestcaseActionWriter {
    void setSeleniumInfo(WebDriver webDriver, WebElement webElement);
    void setObjectInfo(String[] attribute, Integer arrayCount);
}
