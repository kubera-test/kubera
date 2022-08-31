package io.github.kuberatest.actiongenerate.element.testcasewriter;

import io.github.kuberatest.actiongenerate.element.elementwriter.ElementWriter;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class TestcaseAnchorLink extends TestcaseWriterBase implements TestcaseWriter {
    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_ANCHOR_LINK);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeClick(ActionType.CLICK_LINK, elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }

    protected String getElementLabel(ExcelKey defaultObjectKey) {
        String elementName = ExcelForms.getMessage(defaultObjectKey);

        String buttonLabel = webElement.getText();
        if (buttonLabel == null || buttonLabel.trim().length() == 0) {
            return elementName;
        } else {
            return buttonLabel;
        }
    }
}
