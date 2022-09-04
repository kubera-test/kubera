package io.github.kuberatest.actiongenerate.writer.testcasewriter.element;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseButton extends TestcaseElementWriterBase implements TestcaseElementWriter {
    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_BUTTON);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeClick(ActionType.CLICK_BUTTON, elementName);
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
