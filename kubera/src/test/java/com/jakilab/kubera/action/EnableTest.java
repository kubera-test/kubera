package com.jakilab.kubera.action;

import org.junit.jupiter.api.Test;

public class EnableTest extends ActionTest {

    @Test
    public void オブジェクトの使用可能不可能を検証できること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/status\" } }");

        kubera.action("{ \"actionName\": \"isEnable\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"enableButton\", \"enabled\": \"true\" } }");
        kubera.action("{ \"actionName\": \"isEnable\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"disableButton\", \"enabled\": \"false\" } }");
    }

}
