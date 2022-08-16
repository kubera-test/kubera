package com.jakilab.kubera.action.clear;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

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
