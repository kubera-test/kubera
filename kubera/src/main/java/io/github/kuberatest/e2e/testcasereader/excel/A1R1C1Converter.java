package io.github.kuberatest.e2e.testcasereader.excel;

public class A1R1C1Converter {
    public static int row(String cell) {
        return Integer.parseInt(cell.replaceAll("[^0-9]", "")) - 1;
    }

    public static int column(String cell) {
        return cell.replaceAll("[^A-Z]", "").chars().reduce(0, (sum, c) -> sum * 26 + c - 'A' + 1)  - 1;
    }
}
