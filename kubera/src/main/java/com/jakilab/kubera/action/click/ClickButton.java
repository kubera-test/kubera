package com.jakilab.kubera.action.click;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

public class ClickButton extends ObjectAction implements Action {

    @Override
    public void validate() {

    }

    @Override
    public void execute() {
        getSelenideElement().click();
    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
    }

}
