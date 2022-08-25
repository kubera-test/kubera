package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Range extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

    @Override
    public int writeExcel() {
        writeInput();
        writeAssert();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "input[type='range']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Range");
    }

    private void writeInput() {
        write("inputRange", "[範囲]に値を入力する");
    }

    private void writeAssert() {
        write("assertRange", "[範囲]の値を検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[範囲]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[範囲]の使用可能状態を検証する");
    }
}
