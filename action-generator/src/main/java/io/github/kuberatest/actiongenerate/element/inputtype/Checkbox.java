package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.*;

public class Checkbox extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {
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
        return "input[type='checkbox']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:checkbox");
    }

    private void writeInput() {
        write("inputCheckbox", "[チェックボックス]の選択状態を変更する");
    }

    private void writeAssert() {
        write("assertCheckbox", "[チェックボックス]の選択状態を検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[チェックボックス]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[チェックボックス]の使用可能状態を検証する");
    }
}
