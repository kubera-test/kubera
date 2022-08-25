package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickInputSubmitButtonTest extends ActionTest{

    @Test
    public void submitボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSubmitClickResult\", \"checkValue\": \"\" } }");

        kubera.action("{ \"actionName\": \"clickInputSubmitButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSubmit\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputSubmitClickResult\", \"checkValue\": \"Input Submit がクリックされました。\" } }");
    }

}
