package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Tel extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='tel']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Tel");
    }

    private void writeInput() {
        write("inputTel", "[電話番号]に値を入力する");
    }

    private void writeClear() {
        write("clearTel", "[電話番号]の値をクリアする");
    }

    private void writeAssert() {
        write("assertTel", "[電話番号]の値を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[電話番号]の値が空であることを検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[電話番号]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[電話番号]の使用可能状態を検証する");
    }
}
