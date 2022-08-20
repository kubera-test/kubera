package com.kuberatest.e2e.action.assume;

import com.kuberatest.e2e.action.Action;
import com.kuberatest.e2e.action.TestCaseAction;
import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import org.junit.jupiter.api.Assumptions;

public class IgnoreCase extends TestCaseAction implements Action {

    @Override
    public void execute() {
        Assumptions.assumeTrue(false, "スキップします。");
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setTestCaseActionDataFromExcel(excelActionData);
    }

    public static String getKey() {
        return "ignoreCase";
    }
}
