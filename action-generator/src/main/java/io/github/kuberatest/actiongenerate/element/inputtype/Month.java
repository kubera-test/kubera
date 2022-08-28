package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Month extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='month']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Month");
    }

    private void writeInput() {
        write("inputMonth", "[年月項目]に値を入力する");
    }

    private void writeClear() {
        write("clearMonth", "[年月項目]の値をクリアする");
    }

    private void writeAssert() {
        write("assertMonth", "[年月項目]の値を検証する");
    }
    private void writeEmpty() {
        write("isEmpty", "[年月項目]の値が空であることを検証する");
    }

    @Override
    protected String getObjectName() {
        return Messages.getMessage(MessageKey.OBJECT_MONTH);
    }
}
