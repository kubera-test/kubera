package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Color extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='color']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Color");
    }

    private void writeInput() {
        write("inputColor", "[色選択]の色を選択する");
    }

    private void writeAssert() {
        write("assertColor", "[色選択]の色を検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[色選択]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[色選択]の使用可能状態を検証する");
    }
}
