package com.jakilab.kubera.action;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

public class InputKey extends ObjectAction implements Action {

    private String inputKey;

    public String getInputKey() {
        return inputKey;
    }

    public void setInputKey(String inputKey) {
        this.inputKey = inputKey;
    }

    @Override
    public void execute() {
        Selenide.$(getSearchExpression()).pressEnter();
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setInputKey(excelActionData.getTestCase());
    }
}
