package io.github.kuberatest.actiongenerate.element.testcasewriter;

import io.github.kuberatest.actiongenerate.element.elementwriter.ElementWriter;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;
import org.apache.poi.ss.usermodel.*;

public class TestcaseSelect extends TestcaseWriterBase implements TestcaseWriter {
    @Override
    public int writeExcel() {
        String elementName = ExcelForms.getMessage(ExcelKey.OBJECT_SELECT);

        writeTestcase(elementName);

        return activeRow;
    }

    private boolean isMulti() {
        String multiple = webElement.getAttribute("multiple");
        return Boolean.valueOf(multiple);
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
