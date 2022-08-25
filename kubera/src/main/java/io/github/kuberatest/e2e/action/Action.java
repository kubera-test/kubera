package io.github.kuberatest.e2e.action;

import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public interface Action {

    void execute();

    void validate();

    void dispDescription();

    void setFromExcel(ExcelActionData excelActionData);
}
