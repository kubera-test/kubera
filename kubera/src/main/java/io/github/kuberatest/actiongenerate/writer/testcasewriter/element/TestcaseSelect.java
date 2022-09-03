package io.github.kuberatest.actiongenerate.writer.testcasewriter.element;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseSelect extends TestcaseElementWriterBase implements TestcaseElementWriter {
    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_SELECT);
        writeTestcase(elementName);
        return activeRow;
    }

    private boolean isMulti() {
        String multiple = webElement.getAttribute("multiple");
        return Boolean.parseBoolean(multiple);
    }

    private void writeTestcase(String elementName) {
        if (isMulti()) {
            writeSelectValue(ActionType.INPUT_SELECT_MULTI, elementName);
            writeClearValue(ActionType.CLEAR_SELECT_MULTI, elementName);
            writeAssertValue(ActionType.ASSERT_SELECT_MULTI, elementName);
        } else {
            writeSelectValue(ActionType.INPUT_SELECT, elementName);
            writeClearValue(ActionType.CLEAR_SELECT, elementName);
            writeAssertValue(ActionType.ASSERT_SELECT, elementName);
        }
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
