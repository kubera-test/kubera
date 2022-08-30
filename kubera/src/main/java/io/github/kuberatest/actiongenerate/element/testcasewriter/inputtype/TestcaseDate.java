package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseDate extends TestcaseWriterBase implements TestcaseWriter {

    @Override
    public int writeExcel() {
        String elementName = ExcelForms.getMessage(ExcelKey.OBJECT_DATE);

        writeTestcase(elementName);

        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_DATE, elementName);
        writeClearValue(ActionType.CLEAR_DATE, elementName);
        writeAssertValue(ActionType.ASSERT_DATE, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
