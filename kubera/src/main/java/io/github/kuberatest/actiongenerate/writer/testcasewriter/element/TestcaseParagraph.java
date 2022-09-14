package io.github.kuberatest.actiongenerate.writer.testcasewriter.element;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelForms;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseParagraph extends TestcaseElementWriterBase implements TestcaseElementWriter {
    @Override
    public int writeExcel() {
        String element = ExcelForms.getMessage(ExcelKey.OBJECT_PARAGRAPH);
        writeTestcase(element);
        return activeRow;
    }

    private void writeTestcase(String element) {
        writeAssertValue(ActionType.ASSERT_TEXT, element);
        writeIsVisible(element);
        writeIsEnabled(element);
    }
}
