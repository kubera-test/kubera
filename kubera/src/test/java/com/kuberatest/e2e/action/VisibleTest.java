package com.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class VisibleTest extends ActionTest {

    @Test
    public void displayで表示制御されたオブジェクトの表示非表示を検証できること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/status\" } }");

        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayTextButton\", \"visible\": \"true\" } }");
        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayNonTextButton\", \"visible\": \"false\" } }");

        kubera.action("{ \"actionName\": \"clickButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayTextButton\" } }");
        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayTextButton\", \"visible\": \"false\" } }");
        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"displayNonTextButton\", \"visible\": \"True\" } }");
    }

    @Test
    public void 存在しないオブジェクトの非表示を検証できること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/status\" } }");

        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"invisibleNonTextButton\", \"visible\": \"false\" } }");

        kubera.action("{ \"actionName\": \"clickButton\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"visibleTextButton\" } }");
        kubera.action("{ \"actionName\": \"isVisible\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"visibleTextButton\", \"visible\": \"false\" } }");
    }
}
