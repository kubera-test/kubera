package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

public class AssertSelect implements Action {

    private String locator;
    private String searchExpression;
    private String checkValue;
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

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
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
            Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).shouldHave(Condition.value(checkValue));
        } else {
            Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).get(index - 1).shouldHave(Condition.value(checkValue));
        }
    }

    @Override
    public void validate() {

    }
}
