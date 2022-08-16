package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputCheckbox extends ObjectAction implements Action {

    private Boolean checked;

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public void execute() {
        getSelenideElement().setSelected(checked);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setChecked(isCheckedString(excelActionData.getTestCase()));
    }

}
