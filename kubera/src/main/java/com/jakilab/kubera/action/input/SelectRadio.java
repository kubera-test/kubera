package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

import static org.junit.jupiter.api.Assertions.fail;

public class SelectRadio implements Action {

    private String locator;
    private String searchExpression;
    private String selectValue;
    private int index = 0;
    private Boolean selected;

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

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public void execute() {
        if (selected == null) {
            Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).selectRadio(selectValue);
        } else {
            if (index == 0) {
                Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).setSelected(selected);
            } else {
                Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).get(index - 1).setSelected(selected);
            }
        }
    }

    @Override
    public void validate() {
    }
}
