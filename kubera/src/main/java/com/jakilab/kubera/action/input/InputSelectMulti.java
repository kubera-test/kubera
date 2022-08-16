package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

public class InputSelectMulti extends ObjectAction implements Action {

    private String[] selectValues;

    public String[] getSelectValues() {
        return selectValues;
    }

    public void setSelectValues(String[] selectValues) {
        this.selectValues = selectValues;
    }

    @Override
    public void execute() {
        getSelenideElement().selectOptionByValue(selectValues);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setSelectValues(excelActionData.getTestCase().split("[\\s]*,[\\s]*"));
    }
}
