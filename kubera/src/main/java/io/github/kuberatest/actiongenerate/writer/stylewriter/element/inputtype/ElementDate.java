package io.github.kuberatest.actiongenerate.writer.stylewriter.element.inputtype;

import io.github.kuberatest.actiongenerate.writer.stylewriter.element.ElementWriter;
import io.github.kuberatest.actiongenerate.writer.stylewriter.element.ElementWriterBase;
import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ElementDate extends ElementWriterBase implements ElementWriter {
    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, ExcelKey.TITLE_DATE);
    }
}
