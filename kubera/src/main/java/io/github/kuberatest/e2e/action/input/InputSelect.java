package io.github.kuberatest.e2e.action.input;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class InputSelect extends ObjectAction implements Action {

    private String selectValue;

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }

    @Override
    public void execute() {
        getSelenideElement().setValue(selectValue);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setSelectValue(excelActionData.getTestCase());
    }
}
