package io.github.kuberatest.actiongenerate;

import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriterFactory;
import io.github.kuberatest.actiongenerate.element.testcasewriter.TestcaseWriter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ActionGenerator {

    private WebDriver webDriver;
    private Workbook workbook;
    private int sheetCount;
    private int activeRow;

    public void execute(String url) {
        init();
        try {
            actionGenerate(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            quitSelenium();
        }
    }

    public void actionGenerate(String url) throws IOException {
        openPage(url);
        displayUsage();
        workbook = makeExcelFile();
        String inputString = waitKeyPress();
        while (!isExit(inputString)) {
            capture(workbook, inputString);
            inputString = waitKeyPress();
        }
        workbook.write(new FileOutputStream("test.xlsx"));
    }

    public void capture(Workbook workbook, String sheetName) {
        stdout("画面の情報を読み込んでいます。操作せずにそのままお待ちください。");
        Sheet sheet = makeExcelSheet(workbook, sheetName);
        for (ElementType type: ElementType.values()) {
            captureElement(sheet, type);
        }
        stdout("画面の情報を読み込みました。");
    }

    public void captureElement(Sheet sheet, ElementType type) {
        List<WebElement> elements = webDriver.findElements(By.cssSelector(type.getCssSelector()));
        writeElementHeader(sheet, type);

        Map<String, Integer> arrayObjects = findElementDuplicates(elements, type).stream().collect(Collectors.toMap(t -> t, t -> 1));
        for (WebElement element: elements) {
            TestcaseWriter input = TestcaseWriterFactory.getInstance().createElementWriter(type)
                    .setExcelInfo(workbook, sheet, activeRow)
                    .setSeleniumInfo(element)
                    .setObjectInfo(type.getElementWriterInstance().getElementAttribute(element, type), arrayCountUp(arrayObjects, element, type));
            activeRow = input.writeExcel();
       }
    }

    public void writeElementHeader(Sheet sheet, ElementType type) {
        activeRow = type.getElementWriterInstance().writeElementHeader(workbook, sheet, activeRow);
    }

    /**
     * 対象のオブジェクトが配列要素であれば今の要素番号を返却し、arrayObjectsに保存している要素番号を加算しておく。
     * 配列要素ではない場合は、nullを返却する。
     *
     * @param arrayObjects 配列要素であるオブジェクトの識別子と要素番号管理のMap。{@link #findElementDuplicates(List, ElementType)}}の返却値。
     * @param element 対象のオブジェクトのWebElement。
     * @return 対象のオブジェクトの要素番号。
     */
    private Integer arrayCountUp(Map<String, Integer> arrayObjects, WebElement element, ElementType type) {
        Integer arrayCount = arrayObjects.get(getElementSearchExpression(element, type));
        if (arrayCount != null) {
            arrayObjects.put(getElementSearchExpression(element, type), arrayCount + 1);
        }
        return arrayCount;
    }

    private Set<String> findElementDuplicates(List<WebElement> elements, ElementType type) {
        Set<String> arrayChecks = new HashSet<>();

        return elements.stream()
                .map(element -> getElementSearchExpression(element, type))
                .filter(searchExpression -> !arrayChecks.add(searchExpression))
                .collect(Collectors.toSet());
    }

    private String getElementSearchExpression(WebElement element, ElementType type) {
        String[] attribute = type.getElementWriterInstance().getElementAttribute(element, type);
        return attribute[0] + ":" + attribute[1];
    }

    public void openPage(String url) {
        webDriver.get(url);
    }

    private boolean isExit(String input) {
        return input.equals("exit");
    }

    public String waitKeyPress() throws IOException {
//        Scanner scanner = new Scanner(System.in);
        stdout(String.format("シート名を入力してEnterを押してください[%d]:", sheetCount));
//        return scanner.nextLine();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String sheetName = stdin.readLine();
        if (sheetName.trim().length() == 0) {
            sheetName = String.valueOf(sheetCount);
        }
        sheetCount++;
        return sheetName;
    }

    private void displayUsage() {
        String usage = "画面操作シートを作成します。" +
                "\n作成したい画面まで操作したらシート名を入力してEnterを押してください。" +
                "\nシート名を入力しない場合は連続する番号をシート名として作成しますので、何も入力せずにEnterを押してください。" +
                "\n終了する場合は、\"exit\"と入力してEnterを押してください。";
        stdout(usage);
    }

    private void stdout(String message) {
        System.out.println(message);
    }
    public void init() {
        webDriver = new ChromeDriver();
        sheetCount = 1;
    }

    public void quitSelenium() {
        webDriver.quit();
    }

    private Workbook makeExcelFile() {
        return new XSSFWorkbook();
    }

    private Sheet makeExcelSheet(Workbook workbook, String sheetName) {
        activeRow = 0;
        return workbook.createSheet(sheetName);
    }
}
