package com.kuberatest.e2e.action;

import com.kuberatest.e2e.testcasereader.excel.ExcelActionData;

public interface Action {

    void execute();

    void validate();

    void setFromExcel(ExcelActionData excelActionData);
}
