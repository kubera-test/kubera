package com.kuberatest.e2e.action;

import com.codeborne.selenide.Selenide;
import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public class GoToURL extends TestCaseAction implements Action {

    private String url;

    public GoToURL() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        Selenide.open(url);
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setTestCaseActionDataFromExcel(excelActionData);
        this.setUrl(excelActionData.getTestCase());
    }

}
