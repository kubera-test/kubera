package com.kuberatest.e2e.action;

import com.kuberatest.e2e.action.assertion.*;
import com.kuberatest.e2e.action.clear.ClearSelectMulti;
import com.kuberatest.e2e.action.click.ClickButton;
import com.kuberatest.e2e.action.click.ClickImage;
import com.kuberatest.e2e.action.click.ClickLink;
import com.kuberatest.e2e.action.input.*;
import com.kuberatest.e2e.action.screenshot.TakeScreenshot;
import com.kuberatest.e2e.action.status.IsEnable;
import com.kuberatest.e2e.action.status.IsVisible;

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
        actionClassDefinitions.put("isVisible", IsVisible.class);
        actionClassDefinitions.put("isEnable", IsEnable.class);
    }
}
