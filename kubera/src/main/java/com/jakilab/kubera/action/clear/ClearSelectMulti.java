package com.jakilab.kubera.action.clear;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

public class ClearSelectMulti implements Action {

    private String locator;
    private String searchExpression;

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

    @Override
    public void execute() {
        for (SelenideElement element:  Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).$$("option")) {
            element.setSelected(false);
        }
    }
}
