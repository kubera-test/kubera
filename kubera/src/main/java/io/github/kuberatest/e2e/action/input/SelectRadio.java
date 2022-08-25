package io.github.kuberatest.e2e.action.input;

import com.codeborne.selenide.Selenide;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.locate.LocateGenerator;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

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
