package com.kuberatest.e2e.action.assertion;

import com.codeborne.selenide.Condition;
import com.kuberatest.e2e.action.Action;
import com.kuberatest.e2e.action.ObjectAction;
import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class AssertTextbox extends ObjectAction implements Action {

    private String checkValue;

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    @Override
    public void execute() {
        getSelenideElement().shouldHave(Condition.value(checkValue));
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setCheckValue(excelActionData.getTestCase());
    }
}
