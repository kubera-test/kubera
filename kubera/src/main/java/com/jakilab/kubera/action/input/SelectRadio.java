package com.jakilab.kubera.action.input;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

import static org.junit.jupiter.api.Assertions.fail;

public class SelectRadio extends ObjectAction implements Action {

    private String selectValue;
    private Boolean selected;


    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @Override
    public void execute() {
        if (selected == null) {
            Selenide.$(LocateGenerator.getInstance().getLocator(getLocator(), getSearchExpression())).selectRadio(selectValue);
        } else {
            getSelenideElement().setSelected(selected);
        }
    }

    @Override
    public void validate() {
    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setSelectValue(excelActionData.getTestCase());
    }
}
