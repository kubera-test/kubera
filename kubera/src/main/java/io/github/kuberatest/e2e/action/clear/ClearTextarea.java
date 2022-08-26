package io.github.kuberatest.e2e.action.clear;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class ClearTextarea extends ObjectAction implements Action {
    @Override
    public void execute() {
        getSelenideElement().clear();
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
    }
}
