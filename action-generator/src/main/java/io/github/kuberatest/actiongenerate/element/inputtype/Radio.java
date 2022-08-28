package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;
import org.apache.poi.ss.usermodel.*;

public class Radio extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {
    @Override
    public int writeExcel() {
        if (arrayCount != null && arrayCount == 1) {
            writeInput();
            writeAssert();
        }
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "input[type='radio']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Radio");
    }

    private void writeInput() {
        write("selectRadio", "[ラジオボタン]の値を選択する", null);
    }

    private void writeAssert() {
        write("assertRadio", "[ラジオボタン]の値を検証する", null);
    }

    @Override
    protected String getObjectName() {
        return Messages.getMessage(MessageKey.OBJECT_RADIO);
    }
}
