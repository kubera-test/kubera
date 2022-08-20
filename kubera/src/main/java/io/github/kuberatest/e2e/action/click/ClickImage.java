package io.github.kuberatest.e2e.action.click;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class ClickImage extends ObjectAction implements Action {
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
