package com.jakilab.kubera.action;

import com.jakilab.kubera.testcasereader.excel.ExcelActionData;

public interface Action {

    void execute();

    void validate();

    void setFromExcel(ExcelActionData excelActionData);
}
