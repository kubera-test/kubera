package com.jakilab.kubera.action;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakilab.kubera.action.check.CheckRadio;
import com.jakilab.kubera.action.check.CheckText;
import com.jakilab.kubera.action.input.InputText;
import com.jakilab.kubera.action.input.SelectRadio;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionExecuter {
    private static ActionExecuter instance;

    private final Map<String, Class<? extends Action>> actionClassDefinitions = new ConcurrentHashMap<>();
    public static synchronized ActionExecuter getInstance() {
        if (instance == null) {
            instance = new ActionExecuter();
        }
        return instance;
    }

    protected ActionExecuter() {
        actionClassDefinitions.put("gotoURL", GoToURL.class);
        actionClassDefinitions.put("inputText", InputText.class);
        actionClassDefinitions.put("inputKey", InputKey.class);
        actionClassDefinitions.put("checkText", CheckText.class);
        actionClassDefinitions.put("selectRadio", SelectRadio.class);
        actionClassDefinitions.put("checkRadio", CheckRadio.class);
    }

    public void execute(String actionJson) {

        Action action;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(actionJson);
            action = objectMapper.readValue(jsonNode.get("actionJson").toPrettyString(), actionClassDefinitions.get(jsonNode.get("actionName").textValue()));
        } catch (JsonProcessingException e) {
            // TODO: 障害時の処理を検討して実装する
            throw new RuntimeException(e);
        }

        action.execute();
    }
}
