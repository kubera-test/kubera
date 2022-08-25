package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputTimeTest extends ActionTest {

    @Test
    public void 時刻入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertTime\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTime\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputTime\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTime\", \"inputString\": \"23:50\" } }");
        kubera.action("{ \"actionName\": \"assertTime\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTime\", \"checkValue\": \"23:50\" } }");
        kubera.action("{ \"actionName\": \"inputTime\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTime\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertTime\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTime\", \"checkValue\": \"\" } }");
    }
}
