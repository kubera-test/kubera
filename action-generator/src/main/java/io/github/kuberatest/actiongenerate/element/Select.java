package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.*;

public class Select extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {
    @Override
    public int writeExcel() {
        if (isMulti()) {
            writeInputMulti();
            writeAssertMulti();
            writeClearMulti();
        } else {
            writeInput();
            writeAssert();
        }
        writeEmpty();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "select";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Select");
    }

    private boolean isMulti() {
        String multiple = webElement.getAttribute("multiple");
        return Boolean.valueOf(multiple);
    }

    private void writeInputMulti() {
        write("inputSelectMulti", "[複数選択]の選択内容を変更する");
    }

    private void writeAssertMulti() {
        write("assertSelectMulti", "[複数選択]の選択内容を検証する");
    }

    private void writeClearMulti() {
        write("clearSelectMulti", "[複数選択]の選択内容をクリアする");
    }

    private void writeInput() {
        write("inputSelect", "[選択]の選択内容を変更する");
    }

    private void writeAssert() {
        write("assertSelect", "[選択]の選択内容を検証する");
    }

    private void writeEmpty() {
        write("isEmpty", "[選択]が選択されていないことを検証する");
    }

    private void writeIsVisible() {
        write("isVisible", "[選択]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[選択]の使用可能状態を検証する");
    }
}
