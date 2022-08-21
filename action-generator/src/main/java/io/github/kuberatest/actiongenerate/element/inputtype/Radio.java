package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
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

    private void writeIsVisible() {
        write("isVisible", "[ラジオボタン]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[ラジオボタン]の使用可能状態を検証する");
    }
}
