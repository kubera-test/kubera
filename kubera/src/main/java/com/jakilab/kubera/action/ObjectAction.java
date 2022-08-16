package com.jakilab.kubera.action;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ObjectAction extends TestCaseAction implements Action {
    private String locator;
    private String searchExpression;
    private Integer index;

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getSearchExpression() {
        return searchExpression;
    }

    public void setSearchExpression(String searchExpression) {
        this.searchExpression = searchExpression;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setObjectActionDataFromExcel(ExcelActionData excelActionData) {
        setTestCaseActionDataFromExcel(excelActionData);
        setLocator(excelActionData.getLocator());
        setSearchExpression(excelActionData.getSearchExpression());
        setIndex(excelActionData.getIndex());
    }

    protected boolean isInputIndex() {
        return index != null;
    }

    protected SelenideElement getSelenideElement() {
        if (isInputIndex()) {
            return Selenide.$$(LocateGenerator.getInstance().getLocator(getLocator(), getSearchExpression())).get(getIndex() - 1);
        } else {
            return Selenide.$(LocateGenerator.getInstance().getLocator(getLocator(), getSearchExpression()));
        }
    }

    protected boolean isCheckedString(String value) {
        final List<String> checkedString = new ArrayList<>(Arrays.asList("TRUE", "True", "true", "〇", "check", "*", "v", "V"));
        if (checkedString.contains(value)) {
            return true;
        }
        return false;
    }
}
