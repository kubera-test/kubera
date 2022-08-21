package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputTextareaTest extends ActionTest {

    @Test
    public void テキストエリアに対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"inputTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idTextarea\", \"inputString\": \"テキストエリアに改行なしで入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idTextarea\", \"checkValue\": \"テキストエリアに改行なしで入力\" } }");

        kubera.action("{ \"actionName\": \"inputTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idTextarea\", \"inputString\": \"テキストエリアに\\n改行ありで入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextarea\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idTextarea\", \"checkValue\": \"テキストエリアに\\n改行ありで入力\" } }");

    }
}
