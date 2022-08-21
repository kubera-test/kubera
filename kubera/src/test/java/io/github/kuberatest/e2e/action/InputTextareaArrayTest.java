package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputTextareaArrayTest extends ActionTest {

    @Test
    public void テキストエリアの配列に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"inputTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextareaArray\", \"inputString\": \"テキストエリアに改行なしで入力\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextareaArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextareaArray\", \"checkValue\": \"テキストエリアに改行なしで入力\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextareaArray\", \"checkValue\": \"\", \"index\": 3 } }");

    }

}
