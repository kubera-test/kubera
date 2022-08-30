package io.github.kuberatest.actiongenerate.element.testcasewriter.inputtype;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseInputImageButton extends TestcaseWriterBase implements TestcaseWriter {
    @Override
    public int writeExcel() {
        String elementName = ExcelForms.getMessage(ExcelKey.OBJECT_INPUT_IMAGE_BUTTON);

        writeTestcase(elementName);

        return activeRow;
    }

    private void writeTestcase(String elementName) {
        writeClick(ActionType.CLICK_INPUT_IMAGE_BUTTON, elementName);
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }
}
