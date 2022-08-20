package com.kuberatest.e2e.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.kuberatest.e2e.action.Action;
import com.kuberatest.e2e.exception.TestFail;
import com.kuberatest.e2e.locate.LocateGenerator;
import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;

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
