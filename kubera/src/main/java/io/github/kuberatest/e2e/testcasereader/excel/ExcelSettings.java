package io.github.kuberatest.e2e.testcasereader.excel;

public enum ExcelSettings {
    TESTCASE_START_CELL("B2");

    private final String cellPosition;

    public String getCellPosition() {
        return cellPosition;
    }

    ExcelSettings(String cellPosition) {
        this.cellPosition = cellPosition;
    }
}
