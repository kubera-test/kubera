package com.jakilab.kubera.action.click;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

public abstract class ClickObject implements Action {
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
        Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).click();
    }
}
