package com.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickButtonArrayTest extends ActionTest {

    @Test
    public void 配列要素のボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResultArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResultArray\", \"checkValue\": \"\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResultArray\", \"checkValue\": \"\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"clickButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonArray\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResultArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResultArray\", \"checkValue\": \"Buttonがクリックされました\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonClickResultArray\", \"checkValue\": \"\", \"index\": 3 } }");
    }
}
