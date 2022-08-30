package io.github.kuberatest.actiongenerate.element.testcasewriter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;

public interface TestcaseWriter {

    int writeExcel();
    TestcaseWriter setExcelInfo(Workbook workbook, Sheet sheet, int activeRow);
    TestcaseWriter setSeleniumInfo(WebElement webElement);
    TestcaseWriter setObjectInfo(String[] attribute, Integer arrayCount);
}
