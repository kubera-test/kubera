package com.kuberatest.e2e.testcasereader;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {
    @Test
    public void JSONファイルを読みJSON配列のサイズが正しいこと() {
        ArrayNode arrayNode = JsonReader.readJsonArrayFile(getClass().getResourceAsStream("/json/json-array.json"));
        assertEquals(3, arrayNode.size());
    }
}
