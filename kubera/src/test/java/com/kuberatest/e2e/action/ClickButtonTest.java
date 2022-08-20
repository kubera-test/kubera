package com.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickButtonTest extends ActionTest {

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
