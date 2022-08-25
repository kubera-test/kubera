package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickInputImageButtonTest extends ActionTest {

    @Test
    public void Imageボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputImageClickResult\", \"checkValue\": \"\" } }");

        kubera.action("{ \"actionName\": \"clickInputImageButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputImage\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputImageClickResult\", \"checkValue\": \"Input Image がクリックされました。\" } }");
    }
}
