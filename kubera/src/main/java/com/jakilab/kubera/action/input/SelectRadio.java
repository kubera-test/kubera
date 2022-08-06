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

    @Override
    public void execute() {
        if (index == 0) {
            Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).selectRadio(selectValue);
        } else {
            Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).get(index - 1).selectRadio(selectValue);
        }
    }

    @Override
    public void validate() {
        if (index != 0) {
            fail("ラジオボタンには配列要素番号を指定できません。");
        }
    }
}
