package io.github.kuberatest.e2e.action;

import com.codeborne.selenide.WebDriverRunner;
import io.github.kuberatest.e2e.exception.TestFail;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import io.github.kuberatest.util.message.MessageKey;
import org.openqa.selenium.WebDriver;

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

        boolean isFound = false;
        int searchCount = 0;
        // タブのスイッチを安定させるために、Selenideのデフォルト待機の４秒と同じだけ１秒間隔で繰り返す
        while(!isFound && searchCount <= 4) {
            for (String windowHandle : webDriver.getWindowHandles()) {
                webDriver.switchTo().window(windowHandle);
                if (webDriver.getTitle().equals(windowTitle)) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            searchCount++;
        }

        if (!isFound) {
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
