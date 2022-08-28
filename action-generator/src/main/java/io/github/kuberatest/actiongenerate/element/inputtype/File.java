package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class File extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

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
        return "input[type='file']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:File");
    }

    private void writeInput() {
        write("inputFile", "[ファイル]にファイルを選択する");
    }

    private void writeClear() {
        write("clearFile", "[ファイル]の値をクリアする");
    }

    private void writeAssert() {
        write("assertFile", "[ファイル]の値を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[ファイル]の値が空であることを検証する");
    }

    @Override
    protected String getObjectName() {
        return Messages.getMessage(MessageKey.OBJECT_FILE);
    }
}
