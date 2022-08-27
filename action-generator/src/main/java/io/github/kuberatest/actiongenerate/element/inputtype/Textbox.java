package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Textbox extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='text']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Text");
    }

    private void writeInput() {
        write("inputTextbox", "[テキストボックス]に値を入力する");
    }

    private void writeClear() {
        write("clearTextbox", "[テキストボックス]の値をクリアする");
    }

    private void writeAssert() {
        write("assertTextbox", "[テキストボックス]の値を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[テキストボックス]の値が空であることを検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[テキストボックス]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[テキストボックス]の使用可能状態を検証する");
    }
}
