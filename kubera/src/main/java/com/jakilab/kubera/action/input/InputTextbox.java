package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

public class InputTextbox implements Action {

    private String locator;
    private String searchExpression;
    private String inputString;
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

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
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
            Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).setValue(inputString);
        } else {
            Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).get(index - 1).setValue(inputString);
        }
    }
}
