package io.github.kuberatest.e2e.action.input;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class InputSelectMulti extends ObjectAction implements Action {

    private String[] selectValues;

    public String[] getSelectValues() {
        return selectValues;
    }

    public void setSelectValues(String[] selectValues) {
        this.selectValues = selectValues;
    }

    @Override
    public void execute() {
        getSelenideElement().selectOptionByValue(selectValues);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setSelectValues(excelActionData.getTestCase().split("[\\s]*,[\\s]*"));
    }
}
