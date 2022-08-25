package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class EMail extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='email']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:EMail");
    }

    private void writeInput() {
        write("inputEMail", "[E-Mail]に値を入力する");
    }

    private void writeAssert() {
        write("assertEMail", "[E-Mail]の値を検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[E-Mail]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[E-Mail]の使用可能状態を検証する");
    }
}
