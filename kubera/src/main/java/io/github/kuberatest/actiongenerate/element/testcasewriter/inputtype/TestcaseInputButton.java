package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseInputButton extends TestcaseWriterBase implements TestcaseWriter {
    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_INPUT_BUTTON);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeClick(ActionType.CLICK_INPUT_BUTTON, elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }

    @Override
    protected String getElementLabel(ExcelKey defaultObjectKey) {
        String elementName = ExcelForms.getMessage(defaultObjectKey);

        String buttonLabel = webElement.getAttribute("value");
        if (buttonLabel == null || buttonLabel.trim().length() == 0) {
            return elementName;
        } else {
            return buttonLabel;
        }
    }
}
