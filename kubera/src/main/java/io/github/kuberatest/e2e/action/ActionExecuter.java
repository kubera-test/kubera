package io.github.kuberatest.e2e.action;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ActionExecuter extends ActionManager {
    private static ActionExecuter instance;

    public static synchronized ActionExecuter getInstance() {
        if (instance == null) {
            instance = new ActionExecuter();
        }
        return instance;
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

        action.dispDescription();
        action.validate();
        action.execute();
    }
}
