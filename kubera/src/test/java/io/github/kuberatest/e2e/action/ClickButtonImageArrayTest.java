package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickButtonImageArrayTest extends ActionTest {

    @Test
    public void ボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResultArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResultArray\", \"checkValue\": \"\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResultArray\", \"checkValue\": \"\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"clickImage\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageArray\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResultArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResultArray\", \"checkValue\": \"画像がクリックされました\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResultArray\", \"checkValue\": \"\", \"index\": 3 } }");
    }
}
