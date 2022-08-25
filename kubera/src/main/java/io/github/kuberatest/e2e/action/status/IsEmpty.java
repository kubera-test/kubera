package io.github.kuberatest.e2e.action.status;

import com.codeborne.selenide.Condition;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class IsEmpty extends ObjectAction implements Action {
    private Boolean empty;

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    @Override
    public void execute() {
        if (empty) {
            getSelenideElement().shouldBe(Condition.empty);
        }
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setEmpty(isCheckedString(excelActionData.getTestCase()));
    }
}
