package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

import static org.junit.jupiter.api.Assertions.fail;

public class AssertCheckbox extends AssertCheckTypeAction implements Action {

    @Override
    public void execute() {
        isChecked();
    }

    @Override
    public void validate() {

    }
}
