package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class ClickLinkTest extends ActionTest {

    @Test
    public void ボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"clickLink\", "
                + "\"actionJson\": { \"locator\": \"link_text\", \"searchExpression\": \"リンク\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \".about > h1\", \"checkValue\": \"This is an about page\" } }");
    }
}
