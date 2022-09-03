package io.github.kuberatest.actiongenerate.writer.testcasewriter.element.inputtype;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseMonth extends TestcaseElementWriterBase implements TestcaseElementWriter {

    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_MONTH);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_MONTH, elementName);
        writeClearValue(ActionType.CLEAR_MONTH, elementName);
        writeAssertValue(ActionType.ASSERT_MONTH, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
