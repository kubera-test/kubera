package io.github.kuberatest.actiongenerate.writer.testcasewriter.element.inputtype;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseNumber extends TestcaseElementWriterBase implements TestcaseElementWriter {

    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_NUMBER);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_NUMBER, elementName);
        writeClearValue(ActionType.CLEAR_NUMBER, elementName);
        writeAssertValue(ActionType.ASSERT_NUMBER, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
