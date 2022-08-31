package io.github.kuberatest.actiongenerate.element.testcasewriter;

import io.github.kuberatest.actiongenerate.element.elementwriter.ElementWriter;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;
import org.apache.poi.ss.usermodel.*;

public class TestcaseImg extends TestcaseWriterBase implements TestcaseWriter {
    @Override
    public int writeExcel() {
        String elementName = ExcelForms.getMessage(ExcelKey.OBJECT_IMAGE);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeClick(ActionType.CLICK_IMAGE, elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
