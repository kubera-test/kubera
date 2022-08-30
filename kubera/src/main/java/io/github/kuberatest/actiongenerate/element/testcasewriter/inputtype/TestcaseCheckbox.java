package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseCheckbox extends TestcaseWriterBase implements TestcaseWriter {
    @Override
    public int writeExcel() {
        String elementName = ExcelForms.getMessage(ExcelKey.OBJECT_CHECKBOX);

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
