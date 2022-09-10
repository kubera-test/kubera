package io.github.kuberatest.e2e.action;

import com.codeborne.selenide.WebDriverRunner;
import io.github.kuberatest.e2e.exception.TestFail;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import io.github.kuberatest.util.message.MessageKey;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.atomic.AtomicBoolean;

public class SwitchTo extends TestCaseAction implements Action {

    private String windowTitle;

    public String getWindowTitle() {
        return windowTitle;
    }

    public void setWindowTitle(String windowTitle) {
        this.windowTitle = windowTitle;
    }

    @Override
    public void execute() {
        WebDriver webDriver = WebDriverRunner.getWebDriver();

        AtomicBoolean isFound = new AtomicBoolean(false);
        webDriver.getWindowHandles().forEach(windowHandle -> {
            webDriver.switchTo().window(windowHandle);
            if (webDriver.getTitle().equals(windowTitle)) {
                isFound.set(true);
            }
        });

        if (!isFound.get()) {
            TestFail.fail(MessageKey.FAIL_NO_SUCH_WINDOW_TITLE, windowTitle);
        }
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setTestCaseActionDataFromExcel(excelActionData);
        setWindowTitle(excelActionData.getSearchExpression());
    }
}
