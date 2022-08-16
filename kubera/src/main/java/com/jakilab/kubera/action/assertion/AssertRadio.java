package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.exception.TestFail;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

import java.util.Objects;

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
    }

    private void checkedValue() {
        for (SelenideElement element : Selenide.$$(LocateGenerator.getInstance().getLocator(getLocator(), getSearchExpression()))) {
            if (element.has(Condition.checked)) {
                if (!Objects.requireNonNull(element.getValue()).equals(checkValue)) {
                    TestFail.fail("対象エレメントの値が一致しません。", checkValue, element.getValue());
                } else {
                    return;
                }
            }
        }
        if (!checkValue.isEmpty()) {
            TestFail.fail("対象エレメントの値が一致しません。", checkValue, "何も選択されていない");
        }
    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setAssertCheckTypeActionDataFromExcel(excelActionData);
        setCheckValue(excelActionData.getTestCase());
    }
}
