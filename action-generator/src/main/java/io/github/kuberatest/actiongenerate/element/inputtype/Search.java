package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Search extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

    @Override
    public int writeExcel() {
        writeInput();
        writeClear();
        writeAssert();
        writeEmpty();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "input[type='search']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Search");
    }

    private void writeInput() {
        write("inputSearch", "[検索項目]に値を入力する");
    }

    private void writeClear() {
        write("clearSearch", "[検索項目]の値をクリアする");
    }

    private void writeAssert() {
        write("assertSearch", "[検索項目]の値を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[検索項目]の値が空であることを検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[検索項目]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[検索項目]の使用可能状態を検証する");
    }
}
