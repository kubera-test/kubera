package io.github.kuberatest.e2e.action.assertion;

import com.codeborne.selenide.Condition;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.exception.TestFail;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

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
                TestFail.fail("対象エレメントのチェック状態が一致しません。", "未チェック", "チェック");
            }
        } else {
            if (checked) {
                TestFail.fail("対象エレメントのチェック状態が一致しません。", "チェック", "未チェック");
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
