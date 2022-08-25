package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Number extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='number']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Number");
    }

    private void writeInput() {
        write("inputNumber", "[数値項目]に値を入力する");
    }

    private void writeAssert() {
        write("assertNumber", "[数値項目]の値を検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[数値項目]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[数値項目]の使用可能状態を検証する");
    }
}
