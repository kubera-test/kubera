package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.exception.TestFail;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

import static org.junit.jupiter.api.Assertions.fail;

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
