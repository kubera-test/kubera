package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputMonthTest extends ActionTest {

    @Test
    public void 年月入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertMonth\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputMonth\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputMonth\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputMonth\", \"inputString\": \"2022-08\" } }");
        kubera.action("{ \"actionName\": \"assertMonth\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputMonth\", \"checkValue\": \"2022-08\" } }");
        kubera.action("{ \"actionName\": \"inputMonth\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputMonth\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertMonth\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputMonth\", \"checkValue\": \"\" } }");
    }
}
