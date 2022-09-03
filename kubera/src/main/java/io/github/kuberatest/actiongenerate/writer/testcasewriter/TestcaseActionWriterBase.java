package io.github.kuberatest.actiongenerate.writer.testcasewriter;

import io.github.kuberatest.e2e.action.ActionType;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public abstract class TestcaseActionWriterBase implements TestcaseActionWriter {

    protected Workbook workbook;
    protected Sheet sheet;
    protected int activeRow;

    @Override
    public void setExcelInfo(Workbook workbook, Sheet sheet, int activeRow) {
        this.workbook = workbook;
        this.sheet = sheet;
        this.activeRow = activeRow;
    }

    protected void writeAction(ActionType key, String actionCase) {
        write(key.getKey(), actionCase, null, null, null);
    }
    protected void write(String keyValue, String actionCase, String Locator, String searchExpression, Integer arrayCountIndex) {
        Row row = sheet.createRow(activeRow);
        row.createCell(0, CellType.STRING).setCellValue(keyValue);
        row.createCell(1, CellType.STRING).setCellValue(actionCase);
        row.createCell(2, CellType.STRING).setCellValue(Locator);
        row.createCell(3, CellType.STRING).setCellValue(searchExpression);
        if (arrayCountIndex != null) {
            row.createCell(4, CellType.NUMERIC).setCellValue(arrayCountIndex);
        }
        activeRow++;
    }

}
