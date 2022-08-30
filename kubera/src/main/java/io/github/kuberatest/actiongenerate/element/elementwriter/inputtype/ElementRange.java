package io.github.kuberatest.actiongenerate.element.elementwriter.inputtype;

import io.github.kuberatest.actiongenerate.element.elementwriter.ElementWriter;
import io.github.kuberatest.actiongenerate.element.elementwriter.ElementWriterBase;
import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ElementRange extends ElementWriterBase implements ElementWriter {
    @Override
    public int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, ExcelKey.TITLE_RANGE);
    }
}
