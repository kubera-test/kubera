package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickInputResetButtonTest extends ActionTest {

    @Test
    public void resetボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputResetText\", \"inputString\": \"idを入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputResetText\", \"checkValue\": \"idを入力\" } }");

        kubera.action("{ \"actionName\": \"clickInputResetButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputReset\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputResetText\", \"checkValue\": \"\" } }");
    }
}
