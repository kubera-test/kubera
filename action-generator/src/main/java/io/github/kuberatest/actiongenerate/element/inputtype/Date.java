package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Date extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='date']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Date");
    }

    private void writeInput() {
        write("inputDate", "[日付項目]に値を入力する");
    }

    private void writeClear() {
        write("clearDate", "[日付項目]の値をクリアする");
    }

    private void writeAssert() {
        write("assertDate", "[日付項目]の値を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[日付項目]の値が空であることを検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[日付項目]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[日付項目]の使用可能状態を検証する");
    }
}
