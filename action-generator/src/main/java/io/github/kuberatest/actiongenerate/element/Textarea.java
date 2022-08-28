package io.github.kuberatest.actiongenerate.element;

import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Textarea extends ElementWriterBase implements ElementWriter {

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
        return "textarea";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "textarea");
    }

    private void writeInput() {
        write("inputTextarea", "[テキストエリア]に値を入力する");
    }

    private void writeClear() {
        write("clearTextarea", "[テキストエリア]の値をクリアする");
    }

    private void writeAssert() {
        write("assertTextarea", "[テキストエリア]の値を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[テキストエリア]の値が空であることを検証する");
    }

    @Override
    protected String getObjectName() {
        return Messages.getMessage(MessageKey.OBJECT_TEXTAREA);
    }
}
