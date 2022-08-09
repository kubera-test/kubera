package com.jakilab.kubera;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.jakilab.kubera.action.testcasereader.JsonReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class KuberaTest {

    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("jsonTestcaseProvider")
    public void パラメタライズドなテストを実行できる(String testCaseName, ArrayNode testCase) {
        for (JsonNode jsonNode: testCase) {
            kubera.action(jsonNode.toPrettyString());
        }
    }

    static Stream<Arguments> jsonTestcaseProvider() {
        ArrayNode arrayNode = JsonReader.readJsonArrayFile(KuberaTest.class.getResourceAsStream("/json/ParameterizedTest.json"));
        List<Arguments> arguments = new ArrayList<>();
        for (JsonNode jsonNode: arrayNode) {
            arguments.add(Arguments.arguments(jsonNode.get("TestCaseName").toPrettyString(), jsonNode.get("TestCases")));
        }
        return arguments.stream();
//        return Stream.of(
//                Arguments.arguments("テストケース１", "値１"),
//                Arguments.arguments("テストケース２", "値２"),
//                Arguments.arguments("テストケース３", "値３")
//        );
    }
}
