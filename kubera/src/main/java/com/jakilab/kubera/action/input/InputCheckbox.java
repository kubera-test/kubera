package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

public class InputCheckbox implements Action {

    protected String locator;
    protected String searchExpression;
    protected Boolean checked;

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

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public void execute() {
        Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).setSelected(checked);
    }

    @Override
    public void validate() {

    }
}
