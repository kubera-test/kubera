package com.jakilab.kubera.action.status;

import com.codeborne.selenide.Condition;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

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
