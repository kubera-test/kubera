package io.github.kuberatest.e2e.action.assertion;

import com.codeborne.selenide.Condition;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssertTextarea extends ObjectAction implements Action {
    private String checkValue;

    public String getCheckValue() {
        return checkValue;
    }

    public void setCheckValue(String checkValue) {
        this.checkValue = checkValue;
    }

    @Override
    public void execute() {
        if (!checkValue.isEmpty()) {
            getSelenideElement().shouldHave(Condition.exactValue(checkValue));
        } else {
            getSelenideElement().shouldBe(Condition.empty);
        }
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setCheckValue(convertEmptyString(excelActionData.getTestCase()));
    }

    private String convertEmptyString(String value) {
        List<String> emptyString = new ArrayList<>(Arrays.asList("EMPTY", "Empty", "empty", "空"));
        if (emptyString.contains(value)) {
            return "";
        }
        return value;
    }
}
