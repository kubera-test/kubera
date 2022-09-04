package io.github.kuberatest.e2e;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.github.kuberatest.e2e.testcasereader.ExcelReader;
import io.github.kuberatest.e2e.testcasereader.JsonReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

public class KuberaTest {

    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
        kubera.initialize();
    }

    @AfterEach
    public void tearDown() {
        kubera.close();
    }

    @Test
    public void プロパティの値を取得できること() {
        assertEquals("webdriver\\chromedriver.exe", Kubera.getProperties().getWebDriverFilePath());
    }

    @Test
    public void プロパティの値を設定した場合上書きされること() {
        Kubera.getProperties().setWebDriverFilePath("webdriver\\geckodriver.exe");
        assertEquals("webdriver\\geckodriver.exe", Kubera.getProperties().getWebDriverFilePath());
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("jsonTestcaseProvider")
    public void パラメタライズドなテストを実行できる(String testCaseName, ArrayNode testCase) {
        for (JsonNode jsonNode: testCase) {
            kubera.action(jsonNode.toPrettyString());
        }
    }

    static Stream<Arguments> jsonTestcaseProvider() {
        return JsonReader.readJsonArrayFileToArgumentsStream(KuberaTest.class.getResourceAsStream("/json/ParameterizedTest.json"));
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("excelTestcaseProvider")
    public void Excelファイルを読み込んでテストを実行できる(String testCaseName, ArrayNode testCase) {
        for (JsonNode jsonNode: testCase) {
            kubera.action(jsonNode.toPrettyString());
        }
    }

    static Stream<Arguments> excelTestcaseProvider() {
        ExcelReader excelReader = new ExcelReader(KuberaTest.class.getResourceAsStream("/excel/Excelテスト.xlsx"));
        return excelReader.readExcelFileToArgumentsStream();
    }
}
