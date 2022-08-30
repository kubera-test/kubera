package io.github.kuberatest.actiongenerate.element.elementwriter;

import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ElementImg extends ElementWriterBase implements ElementWriter{
    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, ExcelKey.TITLE_IMAGE);
    }
}
