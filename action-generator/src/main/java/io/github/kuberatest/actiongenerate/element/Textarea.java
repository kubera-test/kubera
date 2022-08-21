package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Textarea extends ElementWriterBase implements ElementWriter {

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
        return "textarea";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "textarea");
    }

    private void writeInput() {
        write("inputTextarea", "[テキストエリア]に値を入力する");
    }

    private void writeAssert() {
        write("assertTextarea", "[テキストエリア]に値を入力する");
    }

    private void writeIsVisible() {
        write("isVisible", "[テキストエリア]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[テキストエリア]の使用可能状態を検証する");
    }
}
