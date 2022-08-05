package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClickButtonTest {
    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @Test
    public void ボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResult\", \"checkValue\": \"\" } }");

        kubera.action("{ \"actionName\": \"clickButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButton\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResult\", \"checkValue\": \"Buttonがクリックされました\" } }");
    }
}
