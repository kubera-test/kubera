package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssertText extends ObjectAction implements Action {

    private String checkValue;

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    @Override
    public void execute() {
        if (!checkValue.isEmpty()) {
            getSelenideElement().shouldHave(Condition.text(checkValue));
        } else {
            getSelenideElement().shouldBe(Condition.empty);
        }
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setCheckValue(convertEmptyString(excelActionData.getTestCase()));
    }

    private String convertEmptyString(String value) {
        List<String> emptyString = new ArrayList<>(Arrays.asList("EMPTY", "Empty", "empty", "空"));
        if (emptyString.contains(value)) {
            return "";
        }
        return value;
    }
}
