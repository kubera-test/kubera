package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputDatetimeLocalTest extends ActionTest {

    @Test
    public void 年月日時分入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertDatetimeLocal\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDatetimeLocal\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputDatetimeLocal\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDatetimeLocal\", \"inputString\": \"2022-08-24T23:55\" } }");
        kubera.action("{ \"actionName\": \"assertDatetimeLocal\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDatetimeLocal\", \"checkValue\": \"2022-08-24T23:55\" } }");
        kubera.action("{ \"actionName\": \"clearDatetimeLocal\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDatetimeLocal\" } }");
        kubera.action("{ \"actionName\": \"assertDatetimeLocal\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputDatetimeLocal\", \"checkValue\": \"\" } }");
    }
}
