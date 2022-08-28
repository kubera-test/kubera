package io.github.kuberatest.e2e.action.input;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class InputCheckbox extends ObjectAction implements Action {

    @Override
    public void execute() {
        getSelenideElement().setSelected(true);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
    }

}
