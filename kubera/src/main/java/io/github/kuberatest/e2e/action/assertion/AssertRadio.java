package io.github.kuberatest.e2e.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.exception.TestFail;
import io.github.kuberatest.e2e.locate.LocateGenerator;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;

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
                    TestFail.fail(
                            Messages.getMessage(MessageKey.FAIL_ELEMENT_VALUE_CONDITION_NOT_MATCH),
                            checkValue,
                            element.getValue());
                } else {
                    return;
                }
            }
        }
        if (!checkValue.isEmpty()) {
            TestFail.fail(
                    Messages.getMessage(MessageKey.FAIL_ELEMENT_VALUE_CONDITION_NOT_MATCH),
                    checkValue,
                    Messages.getMessage(MessageKey.PARAM_CONDITION_UNSELECTED));
        }
    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setAssertCheckTypeActionDataFromExcel(excelActionData);
        setCheckValue(excelActionData.getTestCase());
    }
}
