package com.jakilab.kubera;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.ActionExecuter;

public class Kubera {
    public void action(String actionJson) {
        ActionExecuter.getInstance().execute(actionJson);
    }
}
