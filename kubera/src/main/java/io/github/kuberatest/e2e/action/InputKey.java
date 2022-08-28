package io.github.kuberatest.e2e.action;

import com.codeborne.selenide.Selenide;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class InputKey extends ObjectAction implements Action {

    private String inputKey;

    public String getInputKey() {
        return inputKey;
    }

    public void setInputKey(String inputKey) {
        this.inputKey = inputKey;
    }

    @Override
    public void execute() {
        // TODO: Enter以外のキーへの対応
        Selenide.$(getSearchExpression()).pressEnter();
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setInputKey(excelActionData.getTestCase());
    }
}
