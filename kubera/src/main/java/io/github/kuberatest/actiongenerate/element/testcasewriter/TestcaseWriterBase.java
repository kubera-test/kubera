package io.github.kuberatest.actiongenerate.element.testcasewriter;

import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelForms;
import io.github.kuberatest.util.excelform.ExcelKey;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;

public abstract class TestcaseWriterBase implements TestcaseWriter {

    protected  Workbook workbook;
    protected Sheet sheet;
    protected int activeRow;
    protected WebElement webElement;
    protected String[] attribute;
    protected Integer arrayCount;

    @Override
    public TestcaseWriter setExcelInfo(Workbook workbook, Sheet sheet, int activeRow) {
        this.workbook = workbook;
        this.sheet = sheet;
        this.activeRow = activeRow;
        return this;
    }

    @Override
    public TestcaseWriter setSeleniumInfo(WebElement webElement) {
        this.webElement = webElement;
        return this;
    }

    @Override
    public TestcaseWriter setObjectInfo(String[] attribute, Integer arrayCount) {
        this.attribute = attribute;
        this.arrayCount = arrayCount;
        return this;
    }

    @Deprecated
    protected void write(String keyValue, String actionCase) {
        write(keyValue, actionCase, arrayCount);
    }

    protected void write(ActionType keyValue, ExcelKey testCase, Object... args) {
        write(keyValue.getKey(), ExcelForms.getMessage(testCase, args), arrayCount);
    }

    protected void writeInputValue(ActionType keyValue, Object... args) {
        write(keyValue, ExcelKey.TESTCASE_INPUT_VALUE, args);
    }

    protected void writeCheckValue(ActionType keyValue, Object... args) {
        write(keyValue, ExcelKey.TESTCASE_CHECK_VALUE, args);
    }

    protected void writeSelectValue(ActionType keyValue, Object... args) {
        write(keyValue, ExcelKey.TESTCASE_SELECT_VALUE, args);
    }

    protected void writeClearValue(ActionType keyValue, Object... args) {
        write(keyValue, ExcelKey.TESTCASE_CLEAR_VALUE, args);
    }

    protected void writeUncheckValue(ActionType keyValue, Object... args) {
        write(keyValue, ExcelKey.TESTCASE_UNCHECK_VALUE, args);
    }

    protected void writeClick(ActionType keyValue, Object... args) {
        write(keyValue, ExcelKey.TESTCASE_CLICK, args);
    }

    protected void writeAssertValue(ActionType keyValue, Object... args) {
        write(keyValue, ExcelKey.TESTCASE_ASSERT_VALUE, args);
    }

    protected void writeIsEmptyValue(Object... args) {
        write(ActionType.IS_EMPTY, ExcelKey.TESTCASE_IS_EMPTY, args);
    }

    protected void writeIsChecked(Object... args) {
        write(ActionType.IS_CHECKED, ExcelKey.TESTCASE_IS_CHECKED, args);
        write(ActionType.IS_UNCHECKED, ExcelKey.TESTCASE_IS_UNCHECKED, args);
    }

    protected void writeIsVisible(Object... args) {
        write(ActionType.IS_VISIBLE, ExcelKey.TESTCASE_IS_VISIBLE, args);
        write(ActionType.IS_INVISIBLE, ExcelKey.TESTCASE_IS_INVISIBLE, args);
    }


    protected void writeIsEnabled(Object... args) {
        write(ActionType.IS_ENABLE, ExcelKey.TESTCASE_IS_ENABLED, args);
        write(ActionType.IS_DISABLE, ExcelKey.TESTCASE_IS_DISABLED, args);
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
}
