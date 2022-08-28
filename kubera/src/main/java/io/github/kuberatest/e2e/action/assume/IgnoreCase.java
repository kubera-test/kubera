package io.github.kuberatest.e2e.action.assume;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.TestCaseAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import io.github.kuberatest.util.KuberaKey;
import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;
import org.junit.jupiter.api.Assumptions;

public class IgnoreCase extends TestCaseAction implements Action {

    @Override
    public void execute() {
        Assumptions.assumeTrue(false, Messages.getMessage(MessageKey.INFO_SKIP));
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setTestCaseActionDataFromExcel(excelActionData);
    }

    public static String getKey() {
        return KuberaKey.EXCEL_IGNORE_CASE.getKeyName();
    }
}
