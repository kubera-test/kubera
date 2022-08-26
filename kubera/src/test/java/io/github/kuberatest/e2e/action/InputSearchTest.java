package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputSearchTest extends ActionTest {

    @Test
    public void 検索入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertSearch\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSearch\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputSearch\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSearch\", \"inputString\": \"検索文字列を入力\" } }");
        kubera.action("{ \"actionName\": \"assertSearch\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSearch\", \"checkValue\": \"検索文字列を入力\" } }");
        kubera.action("{ \"actionName\": \"clearSearch\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSearch\" } }");
        kubera.action("{ \"actionName\": \"assertSearch\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSearch\", \"checkValue\": \"\" } }");
    }
}
