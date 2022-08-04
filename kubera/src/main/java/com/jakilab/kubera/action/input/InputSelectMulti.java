package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

public class InputSelectMulti implements Action {

    private String locator;
    private String searchExpression;
    private String[] selectValues;

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

    public String[] getSelectValues() {
        return selectValues;
    }

    public void setSelectValues(String[] selectValues) {
        this.selectValues = selectValues;
    }

    @Override
    public void execute() {
        Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).selectOptionByValue(selectValues);
    }
}
