package io.github.kuberatest.e2e.action.status;

import com.codeborne.selenide.Condition;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class IsDisable extends ObjectAction implements Action {

    @Override
    public void execute() {
        getSelenideElement().shouldBe(Condition.disabled);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
    }
}