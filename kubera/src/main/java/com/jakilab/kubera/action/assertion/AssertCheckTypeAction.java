package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.locate.LocateGenerator;

import static org.junit.jupiter.api.Assertions.fail;

public class AssertCheckTypeAction {

    protected String locator;
    protected String searchExpression;
    protected Boolean checked;
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

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    protected void isChecked() {
        if (getElementChecked()) {
            if (!checked) {
                fail("対象のエレメントはチェックされています。\n期待値[未チェック]");
            }
        } else {
            if (checked) {
                fail("対象のエレメントは未チェックです。\n期待値[チェック]");
            }
        }
    }

    private boolean getElementChecked() {
        if (index == 0) {
            return Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).has(Condition.checked);
        } else {
            return Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).get(index - 1).has(Condition.checked);
        }
    }
}
