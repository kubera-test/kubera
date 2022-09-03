package io.github.kuberatest.actiongenerate.writer.testcasewriter.element;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseTextarea extends TestcaseElementWriterBase implements TestcaseElementWriter {

    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_TEXTAREA);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_TEXTAREA, elementName);
        writeClearValue(ActionType.CLEAR_TEXTAREA, elementName);
        writeAssertValue(ActionType.ASSERT_TEXTAREA, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
