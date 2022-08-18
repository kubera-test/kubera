package com.jakilab.kubera.action.assume;

import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.TestCaseAction;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;
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
