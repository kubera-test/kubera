package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputColorTest extends ActionTest {

    @Test
    public void 色入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertColor\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputColor\", \"checkValue\": \"#000000\" } }");
        kubera.action("{ \"actionName\": \"inputColor\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputColor\", \"inputString\": \"#B80000\" } }");
        kubera.action("{ \"actionName\": \"assertColor\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputColor\", \"checkValue\": \"#B80000\" } }");
    }

}
