package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputPasswordTest extends ActionTest {

    @Test
    public void パスワード入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertPassword\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputPassword\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputPassword\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputPassword\", \"inputString\": \"passwordを入力\" } }");
        kubera.action("{ \"actionName\": \"assertPassword\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputPassword\", \"checkValue\": \"passwordを入力\" } }");
        kubera.action("{ \"actionName\": \"inputPassword\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputPassword\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertPassword\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputPassword\", \"checkValue\": \"\" } }");
    }
}
