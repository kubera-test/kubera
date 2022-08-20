package com.kuberatest.e2e.action.assertion;

import com.kuberatest.e2e.action.Action;
import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class AssertCheckbox extends AssertCheckTypeAction implements Action {

    @Override
    public void execute() {
        isChecked();
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setAssertCheckTypeActionDataFromExcel(excelActionData);
    }
}
