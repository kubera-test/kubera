package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.*;

public class Img extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {
    @Override
    public int writeExcel() {
        writeClick();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "img";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Img");
    }

    private void writeClick() {
        write("clickButton", "[画像]をクリックする");
    }
    private void writeIsVisible() {
        write("isVisible", "[画像]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[画像]の使用可能状態を検証する");
    }
}
