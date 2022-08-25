package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputTelTest extends ActionTest {
    @Test
    public void 電話番号入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertTel\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTel\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputTel\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTel\", \"inputString\": \"*819012345678\" } }");
        kubera.action("{ \"actionName\": \"assertTel\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTel\", \"checkValue\": \"*819012345678\" } }");
        kubera.action("{ \"actionName\": \"inputTel\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTel\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertTel\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTel\", \"checkValue\": \"\" } }");
    }

}
