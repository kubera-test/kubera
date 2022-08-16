package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

public class InputSelect extends ObjectAction implements Action {

    private String selectValue;

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }

    @Override
    public void execute() {
        getSelenideElement().setValue(selectValue);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setSelectValue(excelActionData.getTestCase());
    }
}
