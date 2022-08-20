package com.kuberatest.e2e.action.status;

import com.codeborne.selenide.Condition;
import com.kuberatest.e2e.action.Action;
import com.kuberatest.e2e.action.ObjectAction;
import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class IsEnable extends ObjectAction implements Action {
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void execute() {
        Condition condition;
        if (enabled) {
            condition = Condition.enabled;
        } else {
            condition = Condition.disabled;
        }
        getSelenideElement().shouldBe(condition);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setEnabled(isVisibleString(excelActionData.getTestCase()));
    }
}
