package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class SwitchToTest extends ActionTest {

    @Test
    public void 別画面を表示した時そのタブを選択できること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"clickLink\", "
                + "\"actionJson\": { \"locator\": \"link_text\", \"searchExpression\": \"別画面を表示\" } }");

        kubera.action("{ \"actionName\": \"switchTo\", "
                + "\"actionJson\": { \"windowTitle\": \"別画面\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"notes\", \"checkValue\": \"別画面で表示された画面\" } }");
    }

}
