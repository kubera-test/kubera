package com.jakilab.kubera.action;

import com.codeborne.selenide.Selenide;

public class InputKey implements Action {

    private String locator;
    private String searchExpression;
    private String inputKey;

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

    public String getInputKey() {
        return inputKey;
    }

    public void setInputKey(String inputKey) {
        this.inputKey = inputKey;
    }

    @Override
    public void execute() {
        Selenide.$(searchExpression).pressEnter();
    }

    @Override
    public void validate() {

    }
}
