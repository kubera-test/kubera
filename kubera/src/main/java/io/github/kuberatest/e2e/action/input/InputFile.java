package io.github.kuberatest.e2e.action.input;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ObjectAction;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

import java.io.File;

public class InputFile extends ObjectAction implements Action {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        getSelenideElement().uploadFile(new File(InputFile.class.getResource(fileName).getFile()));
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setFileName(excelActionData.getTestCase());
    }
}
