package com.kuberatest.e2e.action.click;

import com.kuberatest.e2e.action.Action;
import com.kuberatest.e2e.action.ObjectAction;
import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class ClickButton extends ObjectAction implements Action {

    @Override
    public void validate() {

    }

    @Override
    public void execute() {
        getSelenideElement().click();
    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
    }

}
