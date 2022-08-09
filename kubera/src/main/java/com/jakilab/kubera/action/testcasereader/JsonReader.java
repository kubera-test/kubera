package com.jakilab.kubera.action.testcasereader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

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
}
