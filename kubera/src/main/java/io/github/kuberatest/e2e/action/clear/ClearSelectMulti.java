package io.github.kuberatest.e2e.action.clear;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.locate.LocateGenerator;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class ClearSelectMulti extends ObjectAction implements Action {

    @Override
    public void execute() {
        for (SelenideElement element:  Selenide.$(LocateGenerator.getInstance().getLocator(getLocator(), getSearchExpression())).$$("option")) {
            element.setSelected(false);
        }
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
    }
}
