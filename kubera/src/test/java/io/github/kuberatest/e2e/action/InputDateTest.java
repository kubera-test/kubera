package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputDateTest extends ActionTest {

    @Test
    public void 日付入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertDate\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDate\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputDate\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDate\", \"inputString\": \"2022-08-24\" } }");
        kubera.action("{ \"actionName\": \"assertDate\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDate\", \"checkValue\": \"2022-08-24\" } }");
        kubera.action("{ \"actionName\": \"inputDate\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDate\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertDate\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDate\", \"checkValue\": \"\" } }");
    }
}
