package com.jakilab.kubera.action.status;

import com.codeborne.selenide.Condition;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

public class IsVisible  extends ObjectAction implements Action {

    private Boolean visible;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public void execute() {
        Condition condition;
        if (visible) {
            condition = Condition.appear;
        } else {
            condition = Condition.disappear;
        }
        getSelenideElement().shouldBe(condition);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setVisible(isVisibleString(excelActionData.getTestCase()));
    }
}
