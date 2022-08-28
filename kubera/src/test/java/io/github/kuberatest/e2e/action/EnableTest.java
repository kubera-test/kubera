package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class EnableTest extends ActionTest {

    @Test
    public void オブジェクトの使用可能不可能を検証できること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/status\" } }");

        kubera.action("{ \"actionName\": \"isEnable\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"enableButton\" } }");
        kubera.action("{ \"actionName\": \"isDisable\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"disableButton\" } }");
    }

}
