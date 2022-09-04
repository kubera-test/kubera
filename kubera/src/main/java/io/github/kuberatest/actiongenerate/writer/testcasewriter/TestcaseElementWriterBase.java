package io.github.kuberatest.actiongenerate.writer.testcasewriter;

import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelForms;
import io.github.kuberatest.util.excelform.ExcelKey;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class TestcaseElementWriterBase extends TestcaseActionWriterBase implements TestcaseElementWriter {

    protected WebDriver webDriver;
    protected WebElement webElement;
    protected String[] attribute;
    protected Integer arrayCount;

    @Override
    public void setSeleniumInfo(WebDriver webDriver, WebElement webElement) {
        this.webDriver = webDriver;
        this.webElement = webElement;
    }

    @Override
    public void setObjectInfo(String[] attribute, Integer arrayCount) {
        this.attribute = attribute;
        this.arrayCount = arrayCount;
    }

    protected void writeTestcase(ActionType keyValue, ExcelKey testCase, Object... args) {
        writeTestcase(keyValue.getKey(), ExcelForms.getMessage(testCase, args), arrayCount);
    }

    protected void writeInputValue(ActionType keyValue, Object... args) {
        writeTestcase(keyValue, ExcelKey.TESTCASE_INPUT_VALUE, args);
    }

    protected void writeCheckValue(ActionType keyValue, Object... args) {
        writeTestcase(keyValue, ExcelKey.TESTCASE_CHECK_VALUE, args);
    }

    protected void writeSelectValue(ActionType keyValue, Object... args) {
        writeTestcase(keyValue, ExcelKey.TESTCASE_SELECT_VALUE, args);
    }

    protected void writeClearValue(ActionType keyValue, Object... args) {
        writeTestcase(keyValue, ExcelKey.TESTCASE_CLEAR_VALUE, args);
    }

    protected void writeUncheckValue(ActionType keyValue, Object... args) {
        writeTestcase(keyValue, ExcelKey.TESTCASE_UNCHECK_VALUE, args);
    }

    protected void writeClick(ActionType keyValue, Object... args) {
        writeTestcase(keyValue, ExcelKey.TESTCASE_CLICK, args);
    }

    protected void writeAssertValue(ActionType keyValue, Object... args) {
        writeTestcase(keyValue, ExcelKey.TESTCASE_ASSERT_VALUE, args);
    }

    protected void writeIsEmptyValue(Object... args) {
        writeTestcase(ActionType.IS_EMPTY, ExcelKey.TESTCASE_IS_EMPTY, args);
    }

    protected void writeIsChecked(Object... args) {
        writeTestcase(ActionType.IS_CHECKED, ExcelKey.TESTCASE_IS_CHECKED, args);
        writeTestcase(ActionType.IS_UNCHECKED, ExcelKey.TESTCASE_IS_UNCHECKED, args);
    }

    protected void writeIsVisible(Object... args) {
        writeTestcase(ActionType.IS_VISIBLE, ExcelKey.TESTCASE_IS_VISIBLE, args);
        writeTestcase(ActionType.IS_INVISIBLE, ExcelKey.TESTCASE_IS_INVISIBLE, args);
    }


    protected void writeIsEnabled(Object... args) {
        writeTestcase(ActionType.IS_ENABLE, ExcelKey.TESTCASE_IS_ENABLED, args);
        writeTestcase(ActionType.IS_DISABLE, ExcelKey.TESTCASE_IS_DISABLED, args);
    }

    protected void writeTestcase(String keyValue, String actionCase, Integer arrayCountIndex) {
        write(keyValue, actionCase, attribute[0], attribute[1], arrayCountIndex);
    }

    protected String getElementLabel(ExcelKey defaultObjectKey) {
        String elementName = ExcelForms.getMessage(defaultObjectKey);

        String elementId = webElement.getAttribute("id");
        if (elementId == null || elementId.trim().length() == 0) {
            return elementName;
        }

        try {
            return webDriver.findElement(By.cssSelector(String.format("label[for='%s']", elementId))).getText();
        } catch (NoSuchElementException e) {
            return elementName;
        }
    }

}
