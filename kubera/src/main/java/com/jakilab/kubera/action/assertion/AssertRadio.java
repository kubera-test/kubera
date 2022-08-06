package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.fail;

public class AssertRadio extends AssertCheckTypeAction implements Action {

    private String checkValue;

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    @Override
    public void execute() {
        if (checked == null) {
            checkedValue();
        } else {
            isChecked();
        }
    }

    @Override
    public void validate() {
        if (getIndex() != 0) {
            fail("ラジオボタンには配列要素番号を指定できません。");
        }
    }

    private void checkedValue() {
        for (SelenideElement element : Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression))) {
            if (element.has(Condition.checked)) {
                if (!Objects.requireNonNull(element.getValue()).equals(checkValue)) {
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

}
