package com.jakilab.kubera.action.assertion;

import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

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
