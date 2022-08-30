package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseEMail extends TestcaseWriterBase implements TestcaseWriter {

    @Override
    public int writeExcel() {
        String elementName = ExcelForms.getMessage(ExcelKey.OBJECT_EMAIL);

        writeTestcase(elementName);

        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_EMAIL, elementName);
        writeClearValue(ActionType.CLEAR_EMAIL, elementName);
        writeAssertValue(ActionType.ASSERT_EMAIL, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
