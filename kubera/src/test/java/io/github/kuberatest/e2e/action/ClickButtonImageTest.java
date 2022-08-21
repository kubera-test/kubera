package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickButtonImageTest extends ActionTest {

    @Test
    public void ボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResult\", \"checkValue\": \"\" } }");

        kubera.action("{ \"actionName\": \"clickImage\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImage\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idButtonImageClickResult\", \"checkValue\": \"画像がクリックされました\" } }");
    }
}