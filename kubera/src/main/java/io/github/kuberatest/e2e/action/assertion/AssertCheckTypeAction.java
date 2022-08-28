package io.github.kuberatest.e2e.action.assertion;

import com.codeborne.selenide.Condition;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.exception.TestFail;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;

public abstract class AssertCheckTypeAction extends ObjectAction {

    protected Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    protected void isChecked() {
        if (getElementChecked()) {
            if (!checked) {
                TestFail.fail(
                        Messages.getMessage(MessageKey.FAIL_ELEMENT_CHECK_CONDITION_NOT_MATCH),
                        Messages.getMessage(MessageKey.PARAM_CONDITION_UNCHECKED),
                        Messages.getMessage(MessageKey.PARAM_CONDITION_CHECKED));
            }
        } else {
            if (checked) {
                TestFail.fail(
                        Messages.getMessage(MessageKey.FAIL_ELEMENT_CHECK_CONDITION_NOT_MATCH),
                        Messages.getMessage(MessageKey.PARAM_CONDITION_CHECKED),
                        Messages.getMessage(MessageKey.PARAM_CONDITION_UNCHECKED));
            }
        }
    }

    private boolean getElementChecked() {
        return getSelenideElement().has(Condition.checked);
    }

    public void setAssertCheckTypeActionDataFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setChecked(isCheckedString(excelActionData.getTestCase()));
    }
}
