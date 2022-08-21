package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;

public interface ElementWriterIndependentOfData {
    String getCssSelector();
    String[] getElementAttribute(WebElement element);
    int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg);
}
