package io.github.kuberatest.actiongenerate.element.inputtype;

import io.github.kuberatest.actiongenerate.element.ElementWriter;
import io.github.kuberatest.actiongenerate.element.ElementWriterBase;
import io.github.kuberatest.actiongenerate.element.ElementWriterIndependentOfData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class InputSubmitButton extends ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {
    @Override
    public int writeExcel() {
        writeClick();
        writeIsVisible();
        writeIsEnabled();
        return activeRow;
    }

    @Override
    public String getCssSelector() {
        return "input[type='submit']";
    }

    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, "Input - Type:Submit");
    }

    private void writeClick() {
        write("clickInputSubmitButton", "[送信ボタン]をクリックする");
    }

    private void writeIsVisible() {
        write("isVisible", "[送信ボタン]の表示状態を検証する");
    }

    private void writeIsEnabled() {
        write("isEnable", "[送信ボタン]の使用可能状態を検証する");
    }
}
