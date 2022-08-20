package com.kuberatest.e2e;

import com.codeborne.selenide.Selenide;
import com.kuberatest.e2e.action.ActionExecuter;

public class Kubera {
    public void action(String actionJson) {
        ActionExecuter.getInstance().execute(actionJson);
    }

    public void close() {
        Selenide.closeWebDriver();
    }
}
