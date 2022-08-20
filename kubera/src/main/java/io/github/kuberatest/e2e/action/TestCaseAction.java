package io.github.kuberatest.e2e.action;

import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public abstract class TestCaseAction implements Action {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTestCaseActionDataFromExcel(ExcelActionData excelActionData) {
        setDescription(excelActionData.getDescription());
    }
}
