package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;

public interface ElementWriter {

    int writeExcel();
    ElementWriter setExcelInfo(Workbook workbook, Sheet sheet, int activeRow);
    ElementWriter setSeleniumInfo(WebElement webElement);
    ElementWriter setObjectInfo(String[] attribute, Integer arrayCount);
}
