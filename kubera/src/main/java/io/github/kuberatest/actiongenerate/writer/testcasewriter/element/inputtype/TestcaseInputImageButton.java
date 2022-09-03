package io.github.kuberatest.actiongenerate.writer.testcasewriter.element.inputtype;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseInputImageButton extends TestcaseElementWriterBase implements TestcaseElementWriter {
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
