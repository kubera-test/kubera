package io.github.kuberatest.actiongenerate.writer.stylewriter;

import io.github.kuberatest.util.excelform.ExcelForms;
import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.*;

public abstract class StyleWriterBase {

    protected int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg, String headerLabel) {
        Row row = sheetArg.createRow(activeRowArg);
        CellStyle cellStyle = getHeaderCellStyle(workbookArg);
        row.setRowStyle(cellStyle);

        row.createCell(1, CellType.STRING).setCellValue(headerLabel);
        row.getCell(1).setCellStyle(cellStyle);

        return activeRowArg + 1;
    }

    protected int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg, ExcelKey headerLabel) {
        return writeElementHeader(workbookArg, sheetArg, activeRowArg, ExcelForms.getMessage(headerLabel));
    }

    private CellStyle getHeaderCellStyle(Workbook workbookArg) {
        CellStyle cellStyle = workbookArg.createCellStyle();
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());

        Font cellFont = workbookArg.createFont();
        cellFont.setColor(IndexedColors.WHITE.getIndex());

        cellStyle.setFont(cellFont);

        return  cellStyle;
    }
}
