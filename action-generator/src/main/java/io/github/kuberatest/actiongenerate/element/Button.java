package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.*;

public class Button extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {
    @Override
    public int writeExcel() {
        writeClick();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "button";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Button");
    }

    private void writeClick() {
        write("clickButton", "[ボタン]をクリックする");
    }
    private void writeIsVisible() {
        write("isVisible", "[ボタン]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[ボタン]の使用可能状態を検証する");
    }
}
