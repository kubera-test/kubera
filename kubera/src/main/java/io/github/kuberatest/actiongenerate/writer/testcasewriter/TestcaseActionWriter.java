package io.github.kuberatest.actiongenerate.writer.testcasewriter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

public interface TestcaseActionWriter {
    int writeExcel();
    void setSeleniumInfo(WebDriver webDriver);
    void setExcelInfo(Workbook workbook, Sheet sheet, int activeRow);

}
