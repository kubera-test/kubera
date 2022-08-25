package io.github.kuberatest.e2e.testcasereader;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.input.InputTextbox;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

public class ExcelReaderTest {
    @Test
    public void getCellInteger_テストケースに空白が設定された場合nullが返されること() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);
        Row row = sheet.getRow(5);
        System.out.println(row.getCell(1));

        Method testMethod = ExcelReader.class.getDeclaredMethod("getCellInteger", Row.class, Integer.TYPE);
        testMethod.setAccessible(true);
        Integer result = (Integer)testMethod.invoke(excelReader, row, 4);

        assertNull(result);
    }

    @Test
    public void getCellInteger_テストケースに数値が設定された場合その数値のIntegerクラスが返されること() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);
        Row row = sheet.getRow(6);
        System.out.println(row.getCell(1));

        Method testMethod = ExcelReader.class.getDeclaredMethod("getCellInteger", Row.class, Integer.TYPE);
        testMethod.setAccessible(true);
        Integer result = (Integer)testMethod.invoke(excelReader, row, 4);

        assertEquals(1, (int) result);
    }

    @Test
    public void getCellInteger_テストケースに設定がない場合nullが返されること() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);
        Row row = sheet.getRow(7);
        System.out.println(row.getCell(1));

        Method testMethod = ExcelReader.class.getDeclaredMethod("getCellInteger", Row.class, Integer.TYPE);
        testMethod.setAccessible(true);
        Integer result = (Integer)testMethod.invoke(excelReader, row, 4);

        assertNull(result);
    }

//    @Test
    public void convertActionToJson() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        InputTextbox action = new InputTextbox();
        action.setDescription("テキストボックスに値を入力する");
        action.setLocator("id");
        action.setSearchExpression("idInputTextbox");
        action.setInputString("テキスト");

        Method testMethod = ExcelReader.class.getDeclaredMethod("convertActionToJson", Action.class);
        testMethod.setAccessible(true);
        String json = (String)testMethod.invoke(excelReader, action);

        System.out.println(json);
    }

    @Test
    public void getActionDataFromExcel_正しく設定されること() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);

        Method testMethod = ExcelReader.class.getDeclaredMethod("getActionDataFromExcel", Sheet.class, Integer.TYPE, Integer.TYPE);
        testMethod.setAccessible(true);
        ExcelActionData excelActionData = (ExcelActionData)testMethod.invoke(excelReader, sheet, 4, 6);

        assertEquals("inputTextbox", excelActionData.getActionKey());
        assertEquals("[テキストボックス]に値を入力する", excelActionData.getDescription());
        assertEquals("id", excelActionData.getLocator());
        assertEquals("idString", excelActionData.getSearchExpression());
        assertEquals("Start", excelActionData.getTestCase());
    }

    @Test
    public void getActionDataFromExcel_テストケースが未設定の場合nullが返されること() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);

        Method testMethod = ExcelReader.class.getDeclaredMethod("getActionDataFromExcel", Sheet.class, Integer.TYPE, Integer.TYPE);
        testMethod.setAccessible(true);
        ExcelActionData excelActionData = (ExcelActionData)testMethod.invoke(excelReader, sheet, 5, 6);

        assertNull(excelActionData);
    }

    @Test
    public void getActionDataFromExcel_ツールのキー文字列が未設定の場合nullが返されること() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);

        Method testMethod = ExcelReader.class.getDeclaredMethod("getActionDataFromExcel", Sheet.class, Integer.TYPE, Integer.TYPE);
        testMethod.setAccessible(true);
        ExcelActionData excelActionData = (ExcelActionData)testMethod.invoke(excelReader, sheet, 8, 6);

        assertNull(excelActionData);
    }

    @Test
    public void getActionDataFromExcel_行が存在していない場合nullが返されること() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);

        Method testMethod = ExcelReader.class.getDeclaredMethod("getActionDataFromExcel", Sheet.class, Integer.TYPE, Integer.TYPE);
        testMethod.setAccessible(true);
        ExcelActionData excelActionData = (ExcelActionData)testMethod.invoke(excelReader, sheet, 10, 6);

        assertNull(excelActionData);
    }

//    @Test
    public void getTestCase() throws Exception {
        ExcelReader excelReader = new ExcelReader(getClass().getResourceAsStream("/excel/UnitTest.xlsx"));
        Sheet sheet = excelReader.getWorkbook().getSheetAt(0);

        Method testMethod = ExcelReader.class.getDeclaredMethod("getTestCase", Sheet.class, Integer.TYPE);
        testMethod.setAccessible(true);
        Arguments arguments = (Arguments)testMethod.invoke(excelReader, sheet, 6);

        System.out.println(arguments.get()[0]);
        System.out.println(arguments.get()[1]);
    }
}
