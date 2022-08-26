package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputWeekTest extends ActionTest {

    @Test
    public void 週入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertWeek\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputWeek\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputWeek\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputWeek\", \"inputString\": \"2022-W22\" } }");
        kubera.action("{ \"actionName\": \"assertWeek\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputWeek\", \"checkValue\": \"2022-W22\" } }");
        kubera.action("{ \"actionName\": \"clearWeek\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputWeek\" } }");
        kubera.action("{ \"actionName\": \"assertWeek\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputWeek\", \"checkValue\": \"\" } }");
    }
}
