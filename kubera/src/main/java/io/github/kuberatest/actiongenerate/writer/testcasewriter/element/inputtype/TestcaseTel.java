package io.github.kuberatest.actiongenerate.writer.testcasewriter.element.inputtype;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseTel extends TestcaseElementWriterBase implements TestcaseElementWriter {

    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_TEL);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_TEL, elementName);
        writeClearValue(ActionType.CLEAR_TEL, elementName);
        writeAssertValue(ActionType.ASSERT_TEL, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
