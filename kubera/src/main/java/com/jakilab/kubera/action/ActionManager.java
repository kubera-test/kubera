package com.jakilab.kubera.action;

import com.jakilab.kubera.action.assertion.*;
import com.jakilab.kubera.action.clear.ClearSelectMulti;
import com.jakilab.kubera.action.click.ClickButton;
import com.jakilab.kubera.action.click.ClickImage;
import com.jakilab.kubera.action.click.ClickLink;
import com.jakilab.kubera.action.input.*;
import com.jakilab.kubera.action.screenshot.TakeScreenshot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionManager {

    protected final Map<String, Class<? extends Action>> actionClassDefinitions = new ConcurrentHashMap<>();

    protected ActionManager() {
        actionClassDefinitions.put("gotoURL", GoToURL.class);
        actionClassDefinitions.put("inputTextbox", InputTextbox.class);
        actionClassDefinitions.put("inputKey", InputKey.class);
        actionClassDefinitions.put("assertTextbox", AssertTextbox.class);
        actionClassDefinitions.put("selectRadio", SelectRadio.class);
        actionClassDefinitions.put("assertRadio", AssertRadio.class);
        actionClassDefinitions.put("inputCheckbox", InputCheckbox.class);
        actionClassDefinitions.put("assertCheckbox", AssertCheckbox.class);
        actionClassDefinitions.put("inputSelect", InputSelect.class);
        actionClassDefinitions.put("assertSelect", AssertSelect.class);
        actionClassDefinitions.put("inputSelectMulti", InputSelectMulti.class);
        actionClassDefinitions.put("assertSelectMulti", AssertSelectMulti.class);
        actionClassDefinitions.put("clearSelectMulti", ClearSelectMulti.class);
        actionClassDefinitions.put("assertText", AssertText.class);
        actionClassDefinitions.put("clickButton", ClickButton.class);
        actionClassDefinitions.put("clickLink", ClickLink.class);
        actionClassDefinitions.put("clickImage", ClickImage.class);

        actionClassDefinitions.put("takeScreenshot", TakeScreenshot.class);
    }
}
