package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseDatetimeLocal extends TestcaseWriterBase implements TestcaseWriter {

    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_DATETIME_LOCAL);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_DATETIME_LOCAL, elementName);
        writeClearValue(ActionType.CLEAR_DATETIME_LOCAL, elementName);
        writeAssertValue(ActionType.ASSERT_DATETIME_LOCAL, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
