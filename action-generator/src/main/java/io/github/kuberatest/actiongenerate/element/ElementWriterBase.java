package io.github.kuberatest.actiongenerate.element;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public abstract class ElementWriterBase implements ElementWriter, ElementWriterIndependentOfData {

    protected  Workbook workbook;
    protected Sheet sheet;
    protected int activeRow;
    protected WebElement webElement;
    protected String[] attribute;
    protected Integer arrayCount;

    @Override
    public ElementWriter setExcelInfo(Workbook workbook, Sheet sheet, int activeRow) {
        this.workbook = workbook;
        this.sheet = sheet;
        this.activeRow = activeRow;
        return this;
    }

    @Override
    public ElementWriter setSeleniumInfo(WebElement webElement) {
        this.webElement = webElement;
        return this;
    }

    @Override
    public ElementWriter setObjectInfo(String[] attribute, Integer arrayCount) {
        this.attribute = attribute;
        this.arrayCount = arrayCount;
        return this;
    }

    @Override
    public String[] getElementAttribute(WebElement element) {
        String attrName = element.getAttribute("name");
        if (attrName.trim().length() != 0) {
            return Stream.of("name", attrName).toArray(String[]::new);
        }
        String attrId = element.getAttribute("id");
        if (attrId.trim().length() != 0) {
            return Stream.of("id", attrId).toArray(String[]::new);
        }
        return Stream.of("css_selector", String.format(getCssSelector())).toArray(String[]::new);
    }

    protected int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg, String headerLabel) {
        Row row = sheetArg.createRow(activeRowArg);
        CellStyle cellStyle = getHeaderCellStyle(workbookArg);
        row.setRowStyle(cellStyle);

        row.createCell(1, CellType.STRING).setCellValue(headerLabel);
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

    protected void write(String keyValue, String actionCase) {
        write(keyValue, actionCase, arrayCount);
    }

    protected void write(String keyValue, String actionCase, Integer arrayCountIndex) {
        Row row = sheet.createRow(activeRow);
        row.createCell(0, CellType.STRING).setCellValue(keyValue);
        row.createCell(1, CellType.STRING).setCellValue(actionCase);
        row.createCell(2, CellType.STRING).setCellValue(attribute[0]);
        row.createCell(3, CellType.STRING).setCellValue(attribute[1]);
        if (arrayCountIndex != null) {
            row.createCell(4, CellType.NUMERIC).setCellValue(arrayCountIndex);
        }
        activeRow++;
    }

    protected void writeIsVisible() {
        write("isVisible", String.format("[%s]が表示されていることを検証する", getObjectName()));
        write("isInvisible", String.format("[%s]が表示されていないことを検証する", getObjectName()));
    }


    protected void writeIsEnabled() {
        write("isEnable", String.format("[%s]の使用可能であることを検証する", getObjectName()));
        write("isDisable", String.format("[%s]の使用不可であることを検証する", getObjectName()));
    }

    protected abstract String getObjectName();
}
