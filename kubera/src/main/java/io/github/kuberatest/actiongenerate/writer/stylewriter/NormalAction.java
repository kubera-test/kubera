package io.github.kuberatest.actiongenerate.writer.stylewriter;

import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class NormalAction extends StyleWriterBase implements StyleWriter {
    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, ExcelKey.TITLE_NORMAL_ACTION);
    }
}
