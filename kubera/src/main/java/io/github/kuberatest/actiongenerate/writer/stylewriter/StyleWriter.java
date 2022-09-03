package io.github.kuberatest.actiongenerate.writer.stylewriter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface StyleWriter {
    int writeElementHeader(Workbook workbookArg, Sheet sheetArg, int activeRowArg);}
