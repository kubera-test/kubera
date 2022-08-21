package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public class AnchorLink extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {
    @Override
    public int writeExcel() {
        writeClick();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "a";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Anchor Link");
    }

    @Override
    public String[] getElementAttribute(WebElement element) {
        String linkText = element.getText();
        return Stream.of("link_text", linkText).toArray(String[]::new);
    }

    private void writeClick() {
        write("clickLink", "[リンク]をクリックする");
    }

    private void writeIsVisible() {
        write("isVisible", "[リンク]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[リンク]の使用可能状態を検証する");
    }
}
