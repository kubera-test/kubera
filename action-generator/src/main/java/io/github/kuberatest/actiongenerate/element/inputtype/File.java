package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class File extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

    @Override
    public int writeExcel() {
        writeInput();
        writeAssert();
        writeEmpty();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "input[type='file']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:File");
    }

    private void writeInput() {
        write("inputFile", "[ファイル]にファイルを選択する");
    }

    private void writeAssert() {
        write("assertFile", "[ファイル]の値を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[ファイル]の値が空であることを検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[ファイル]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[ファイル]の使用可能状態を検証する");
    }
}
