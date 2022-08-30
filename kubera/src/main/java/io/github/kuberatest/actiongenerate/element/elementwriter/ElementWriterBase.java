package io.github.kuberatest.actiongenerate.element.elementwriter;

import io.github.kuberatest.actiongenerate.ElementType;
import io.github.kuberatest.util.KuberaKey;
import io.github.kuberatest.util.excelform.ExcelForms;
import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public abstract class ElementWriterBase implements ElementWriter {

    @Override
    public String[] getElementAttribute(WebElement element, ElementType elementType) {
        String attrName = element.getAttribute("name");
        if (attrName.trim().length() != 0) {
            return Stream.of(KuberaKey.LOCATOR_NAME.getKeyName(), attrName).toArray(String[]::new);
        }
        String attrId = element.getAttribute("id");
        if (attrId.trim().length() != 0) {
            return Stream.of(KuberaKey.LOCATOR_ID.getKeyName(), attrId).toArray(String[]::new);
        }
        return Stream.of(KuberaKey.LOCATOR_CSS_SELECTOR.getKeyName(), String.format(elementType.getCssSelector())).toArray(String[]::new);
    }

    @Deprecated
    protected int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg, String headerLabel) {
        Row row = sheetArg.createRow(activeRowArg);
        CellStyle cellStyle = getHeaderCellStyle(workbookArg);
        row.setRowStyle(cellStyle);

        row.createCell(1, CellType.STRING).setCellValue(headerLabel);
        row.getCell(1).setCellStyle(cellStyle);

        return activeRowArg + 1;
    }

    protected int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg, ExcelKey headerLabel) {
        Row row = sheetArg.createRow(activeRowArg);
        CellStyle cellStyle = getHeaderCellStyle(workbookArg);
        row.setRowStyle(cellStyle);

        row.createCell(1, CellType.STRING).setCellValue(ExcelForms.getMessage(headerLabel));
        row.getCell(1).setCellStyle(cellStyle);

        return activeRowArg + 1;
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
