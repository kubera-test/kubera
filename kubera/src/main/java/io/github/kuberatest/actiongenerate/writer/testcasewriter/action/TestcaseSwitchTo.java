package io.github.kuberatest.actiongenerate.writer.testcasewriter.action;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseActionWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseActionWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelForms;
import io.github.kuberatest.util.excelform.ExcelKey;

public class TestcaseSwitchTo extends TestcaseActionWriterBase implements TestcaseActionWriter {
    @Override
    public int writeExcel() {
        write(ActionType.SWITCH_TO.getKey(),
                ExcelForms.getMessage(ExcelKey.TESTCASE_SWITCH_TO, webDriver.getTitle()),
                "",
                webDriver.getTitle(),
                null);
        return activeRow;
    }
}
