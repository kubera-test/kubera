package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickInputButtonTest extends ActionTest {

    @Test
    public void Inputボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputButtonClickResult\", \"checkValue\": \"\" } }");

        kubera.action("{ \"actionName\": \"clickInputButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputButton\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputButtonClickResult\", \"checkValue\": \"Input Button がクリックされました。\" } }");
    }
}
