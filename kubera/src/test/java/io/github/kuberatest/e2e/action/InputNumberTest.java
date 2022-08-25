package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputNumberTest extends ActionTest {

    @Test
    public void 数値入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertNumber\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputNumber\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputNumber\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputNumber\", \"inputString\": \"10\" } }");
        kubera.action("{ \"actionName\": \"assertNumber\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputNumber\", \"checkValue\": \"10\" } }");
        kubera.action("{ \"actionName\": \"inputNumber\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputNumber\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertNumber\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputNumber\", \"checkValue\": \"\" } }");
    }

}
