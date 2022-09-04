package io.github.kuberatest.actiongenerate.writer.testcasewriter.action;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseActionWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseActionWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelForms;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseGoToURL extends TestcaseActionWriterBase implements TestcaseActionWriter {
    @Override
    public int writeExcel() {
        writeAction(ActionType.GOTO_URL, ExcelForms.getMessage(ExcelKey.TESTCASE_GO_TO_URL, ExcelForms.getMessage(ExcelKey.OBJECT_PAGE)));
        return activeRow;
    }
}
