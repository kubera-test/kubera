package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.actiongenerate.element.elementwriter.ElementWriter;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TestcaseMonth extends TestcaseWriterBase implements TestcaseWriter {

    @Override
    public int writeExcel() {
        String elementName = ExcelForms.getMessage(ExcelKey.OBJECT_MONTH);

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
