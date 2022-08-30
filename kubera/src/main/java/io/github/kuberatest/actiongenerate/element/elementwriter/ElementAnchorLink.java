package io.github.kuberatest.actiongenerate.element.elementwriter;

import io.github.kuberatest.actiongenerate.ElementType;
import io.github.kuberatest.util.KuberaKey;
import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class ElementAnchorLink extends ElementWriterBase implements ElementWriter{
    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, ExcelKey.TITLE_ANCHOR_LINK);
    }

    @Override
    public String[] getElementAttribute(WebElement element, ElementType elementType) {
        String linkText = element.getText();
        return Stream.of(KuberaKey.LOCATOR_LINK_TEXT.getKeyName(), linkText).toArray(String[]::new);
    }

}
