package io.github.kuberatest.actiongenerate.writer.testcasewriter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface TestcaseActionWriter {
    int writeExcel();
    void setExcelInfo(Workbook workbook, Sheet sheet, int activeRow);

}
