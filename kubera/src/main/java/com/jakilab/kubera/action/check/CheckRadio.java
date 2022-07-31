package com.jakilab.kubera.action.check;

import static org.junit.jupiter.api.Assertions.fail;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementShould;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

import java.util.ListIterator;

public class CheckRadio implements Action {

    private String locator;
    private String searchExpression;
    private String checkValue;
    private Boolean checked;

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

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public void execute() {
        if (checkValue != null && !checkValue.isEmpty()) {
            checkedValue();
        } else {
            isChecked();
        }
    }

    private void checkedValue() {
        ListIterator<SelenideElement> options = Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).listIterator();
        while(options.hasNext()) {
            SelenideElement element = options.next();
            if (element.has(Condition.checked)) {
                if (!element.getValue().equals(checkValue)) {
                    fail(String.format("対象のエレメントは[%s]が選択されています。\n期待値[%s]", element.getValue(), checkValue));
                } else {
                    return;
                }
            }
        }
        if (!checkValue.isEmpty()) {
            fail(String.format("対象のエレメントは何も選択されていませんでした。\n期待値[%s]", checkValue));
        }
    }

    private void isChecked() {
        if (Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).has(Condition.checked)) {
            if (!checked) {
                fail("対象のエレメントはチェックされています。\n期待値[未チェック]");
            }
        } else {
            if (checked) {
                fail("対象のエレメントは未チェックです。\n期待値[チェック]");
            }
        }
    }
}
