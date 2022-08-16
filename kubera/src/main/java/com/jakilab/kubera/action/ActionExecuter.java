package com.jakilab.kubera.action;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakilab.kubera.action.assertion.*;
import com.jakilab.kubera.action.clear.ClearSelectMulti;
import com.jakilab.kubera.action.click.ClickButton;
import com.jakilab.kubera.action.click.ClickImage;
import com.jakilab.kubera.action.click.ClickLink;
import com.jakilab.kubera.action.input.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionExecuter extends ActionManager {
    private static ActionExecuter instance;

//    private final Map<String, Class<? extends Action>> actionClassDefinitions = new ConcurrentHashMap<>();
    public static synchronized ActionExecuter getInstance() {
        if (instance == null) {
            instance = new ActionExecuter();
        }
        return instance;
    }

//    protected ActionExecuter() {
//        actionClassDefinitions.put("gotoURL", GoToURL.class);
//        actionClassDefinitions.put("inputTextbox", InputTextbox.class);
//        actionClassDefinitions.put("inputKey", InputKey.class);
//        actionClassDefinitions.put("assertTextbox", AssertTextbox.class);
//        actionClassDefinitions.put("selectRadio", SelectRadio.class);
//        actionClassDefinitions.put("assertRadio", AssertRadio.class);
//        actionClassDefinitions.put("inputCheckbox", InputCheckbox.class);
//        actionClassDefinitions.put("assertCheckbox", AssertCheckbox.class);
//        actionClassDefinitions.put("inputSelect", InputSelect.class);
//        actionClassDefinitions.put("assertSelect", AssertSelect.class);
//        actionClassDefinitions.put("inputSelectMulti", InputSelectMulti.class);
//        actionClassDefinitions.put("assertSelectMulti", AssertSelectMulti.class);
//        actionClassDefinitions.put("clearSelectMulti", ClearSelectMulti.class);
//        actionClassDefinitions.put("assertText", AssertText.class);
//        actionClassDefinitions.put("clickButton", ClickButton.class);
//        actionClassDefinitions.put("clickLink", ClickLink.class);
//        actionClassDefinitions.put("clickImage", ClickImage.class);
//    }

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

        action.validate();
        action.execute();
    }
}
