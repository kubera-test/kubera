package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

public class InputSelectMulti implements Action {

    private String locator;
    private String searchExpression;
    private String[] selectValues;
    private int index = 0;

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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void execute() {
        if (index == 0) {
            Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).selectOptionByValue(selectValues);
        } else {
            Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).get(index - 1).selectOptionByValue(selectValues);
        }
    }

    @Override
    public void validate() {

    }
}
