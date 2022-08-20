package io.github.kuberatest.e2e.testcasereader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.assume.IgnoreCase;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionConverter;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import io.github.kuberatest.e2e.exception.TestFail;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ExcelReader {

    private final int testCaseNameRowIndex = 0;
    private final int testIgnoreRowIndex = testCaseNameRowIndex + 1;
    private final int toolKeyColIndex = 0;
    private final int testCaseStartColIndex = toolKeyColIndex + 5;
    private Workbook workbook;

    public ExcelReader(InputStream excelFileInputStream) {
        try {
            workbook = WorkbookFactory.create(excelFileInputStream);
        } catch (IOException e) {
            // TODO: 共通的なエラー処理を後で入れる
            throw new RuntimeException(e);
        }
    }

    public Workbook getWorkbook() {
        return workbook;
    }

    public Stream<Arguments> readExcelFileToArgumentsStream() {
        return readWorkbookToArgumentsStream();
    }

    private Stream<Arguments> readWorkbookToArgumentsStream() {
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        List<Arguments> arguments = new ArrayList<>();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            arguments.addAll(getTestCaseArgumentsStreamFromSheet(sheet));
        }
        return arguments.stream();
    }

    private List<Arguments> getTestCaseArgumentsStreamFromSheet(Sheet sheet) {
        List<Arguments> arguments = new ArrayList<>();
        int caseSize = getTestCaseSize(sheet);
        for (int colIndex = testCaseStartColIndex; colIndex < testCaseStartColIndex + caseSize; colIndex++) {
            if (isIgnoreCase(sheet, colIndex)) {
                // Excelの場合はIgnoreCaseクラスを使わずにスキップする
                continue;
            }

            arguments.add(getTestCase(sheet, colIndex));
        }
        return arguments;
    }

    private boolean isIgnoreCase(Sheet sheet, int colIndex) {
        Row row = sheet.getRow(testIgnoreRowIndex);
        Cell ignoreKeyCell = row.getCell(toolKeyColIndex);
        if (ignoreKeyCell != null && ignoreKeyCell.getStringCellValue().equals(IgnoreCase.getKey())) {
            // MEMO: 何かしら文字が入力されていたらスキップ
            return !isCellEmpty(row.getCell(colIndex));
        }
        return false;
    }

    private Arguments getTestCase(Sheet sheet, int colIndex) {
        String testCaseName = getTestCaseName(sheet, colIndex);
        if (testCaseName.trim().length() == 0) {
            return null;
        }

        int testCaseStartRowIndex = getTestCaseStartRowIndex(sheet);
        if (testCaseStartRowIndex == -1) {
            TestFail.fail(String.format("テストケース内容の開始行が見つかりませんでした。\n検索した列番号[%d]", toolKeyColIndex));
        }

        StringBuilder jsonString = new StringBuilder().append("[");
        for (int rowIndex = testCaseStartRowIndex; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            ExcelActionData excelActionData = getActionDataFromExcel(sheet, rowIndex, colIndex);
            if (excelActionData == null) {
                continue;
            }
            Action action = ExcelActionConverter.getInstance().convert(excelActionData);
            if (jsonString.toString().length() != 1) {
                jsonString.append(",");
            }
            jsonString.append(convertActionToJson(excelActionData.getActionKey(), action));
        }
        jsonString.append("]");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode arrayNode;
        try {
            arrayNode = objectMapper.readTree(jsonString.toString());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Arguments.of(testCaseName, arrayNode);
    }

    private int getTestCaseStartRowIndex(Sheet sheet) {
        for (int rowIndex = testCaseNameRowIndex; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            Cell keyCell = row.getCell(toolKeyColIndex);
            // TODO: 文字列をどこかで定義
            if (keyCell != null && keyCell.getStringCellValue().equals("TestCase")) {
                return rowIndex + 1;
            }
        }
        return -1;
    }

    private String getTestCaseName(Sheet sheet, int colIndex) {
        Row testCaseNameRow = sheet.getRow(testCaseNameRowIndex);
        Cell testCaseNameKeyCell = testCaseNameRow.getCell(toolKeyColIndex);
        // TODO: 文字列をどこかで定義
        if (testCaseNameKeyCell == null || !testCaseNameKeyCell.getStringCellValue().equals("TestCaseName")) {
            TestFail.fail("所定の位置にテストケース名の行が存在していません。");
        }

        Cell testCaseNameCell = testCaseNameRow.getCell(colIndex);
        if (testCaseNameCell == null) {
            return "";
        }
        return testCaseNameCell.getStringCellValue();
    }

    private ExcelActionData getActionDataFromExcel(Sheet sheet, int rowIndex, int testCaseColIndex) {
        Row row = sheet.getRow(rowIndex);
        if (row == null) {
            return null;
        }
        if (isCellEmpty(row.getCell(toolKeyColIndex))) {
            return null;
        }
        if (isCellEmpty(row.getCell(testCaseColIndex))) {
            return null;
        }

        ExcelActionData excelActionData = new ExcelActionData();
        excelActionData.setActionKey(getCellString(row, toolKeyColIndex));
        excelActionData.setDescription(getCellString(row, toolKeyColIndex + 1));
        excelActionData.setLocator(getCellString(row, toolKeyColIndex + 2));
        excelActionData.setSearchExpression(getCellString(row, toolKeyColIndex + 3));
        excelActionData.setIndex(getCellInteger(row, toolKeyColIndex + 4));
        excelActionData.setTestCase(getCellString(row, testCaseColIndex));

        return excelActionData;
    }

    private String convertActionToJson(String actionName, Action action) {
        String actionJson;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            actionJson = objectMapper.writeValueAsString(action);
        } catch (JsonProcessingException e) {
            // MEMO: ほぼ発生が考えられないのでこのまま
            throw new RuntimeException(e);
        }

//        ActionBase actionBase = new ActionBase();
//        actionBase.setActionName(actionName);
//        actionBase.setActionJson(actionJson);
//        try {
//            return objectMapper.writeValueAsString(actionBase);
//        } catch (JsonProcessingException e) {
//            // MEMO: ほぼ発生が考えられないのでこのまま
//            throw new RuntimeException(e);
//        }
        StringBuilder jsonString = new StringBuilder();
        jsonString
                .append(String.format("{\"actionName\": \"%s\",", actionName))
                .append(String.format("\"actionJson\": %s }", actionJson));
        return jsonString.toString();
    }

    private int getTestCaseSize(Sheet sheet) {
        return sheet.getRow(testCaseNameRowIndex).getLastCellNum() - testCaseStartColIndex;
    }

    private boolean isCellEmpty(Cell cell) {
        if (cell == null || cell.getCellType().equals(CellType.BLANK)) {
            return true;
        }
        return false;
    }

    private String getCellString(Row row, int colIndex) {
        Cell cell = row.getCell(colIndex);
        if (!isCellEmpty(cell)) {
            return cell.getStringCellValue();
        }
        return null;
    }

    private Integer getCellInteger(Row row, int colIndex) {
        Cell cell = row.getCell(colIndex);
        if (!isCellEmpty(cell)) {
            return Double.valueOf(cell.getNumericCellValue()).intValue();
        }
        return null;
    }
}
