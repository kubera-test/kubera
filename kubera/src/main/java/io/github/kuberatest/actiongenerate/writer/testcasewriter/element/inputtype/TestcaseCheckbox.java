package io.github.kuberatest.actiongenerate.writer.testcasewriter.element.inputtype;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseCheckbox extends TestcaseElementWriterBase implements TestcaseElementWriter {
    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_CHECKBOX);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeCheckValue(ActionType.INPUT_CHECKBOX, elementName);
        writeUncheckValue(ActionType.CLEAR_CHECKBOX, elementName);
        writeIsChecked(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
