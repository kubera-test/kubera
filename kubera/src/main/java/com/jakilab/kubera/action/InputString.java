package com.jakilab.kubera.action;

import com.codeborne.selenide.Selenide;

public class InputString implements Action {

    private String locator;
    private String searchExpression;
    private String inputString;

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

    @Override
    public void execute() {
        Selenide.$(searchExpression).setValue(inputString);
    }
}
