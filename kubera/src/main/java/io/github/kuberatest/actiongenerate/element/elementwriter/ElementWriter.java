package io.github.kuberatest.actiongenerate.element.elementwriter;

import io.github.kuberatest.actiongenerate.ElementType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;

public interface ElementWriter {
    String[] getElementAttribute(WebElement element, ElementType elementType);
    int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg);
}
