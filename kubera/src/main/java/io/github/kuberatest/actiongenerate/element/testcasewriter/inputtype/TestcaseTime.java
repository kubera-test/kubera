package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.actiongenerate.element.elementwriter.ElementWriter;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TestcaseTime extends TestcaseWriterBase implements TestcaseWriter {

    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_TIME);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeInputValue(ActionType.INPUT_TIME, elementName);
        writeClearValue(ActionType.CLEAR_TIME, elementName);
        writeAssertValue(ActionType.ASSERT_TIME, elementName);
        writeIsEmptyValue(elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
