package com.kuberatest.e2e.testcasereader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.JsonArray;
import org.junit.jupiter.params.provider.Arguments;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class JsonReader {
    public static ArrayNode readJsonArrayFile(InputStream jsonFileInputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return (ArrayNode)objectMapper.readTree(jsonFileInputStream);
        } catch (IOException e) {
            // TODO: 共通的なエラー処理を後で入れる
            throw new RuntimeException(e);
        }
    }

    public static Stream<Arguments> readJsonArrayFileToArgumentsStream(InputStream jsonFileInputStream) {
        ArrayNode arrayNode = readJsonArrayFile(jsonFileInputStream);
        List<Arguments> arguments = new ArrayList<>();
        for (JsonNode jsonNode: arrayNode) {
            arguments.add(Arguments.arguments(jsonNode.get("TestCaseName").toPrettyString(), jsonNode.get("TestCases")));
        }
        return arguments.stream();
    }
}
