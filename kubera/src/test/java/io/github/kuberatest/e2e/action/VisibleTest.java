package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class VisibleTest extends ActionTest {

    @Test
    public void displayで表示制御されたオブジェクトの表示非表示を検証できること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/status\" } }");

        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayTextButton\" } }");
        kubera.action("{ \"actionName\": \"isInvisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayNonTextButton\" } }");

        kubera.action("{ \"actionName\": \"clickButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayTextButton\" } }");
        kubera.action("{ \"actionName\": \"isInvisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayTextButton\" } }");
        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayNonTextButton\" } }");
    }

    @Test
    public void 存在しないオブジェクトの非表示を検証できること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/status\" } }");

        kubera.action("{ \"actionName\": \"isInvisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"invisibleNonTextButton\" } }");

        kubera.action("{ \"actionName\": \"clickButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"visibleTextButton\" } }");
        kubera.action("{ \"actionName\": \"isInvisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"visibleTextButton\" } }");
    }
}
