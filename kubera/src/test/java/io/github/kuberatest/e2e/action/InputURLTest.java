package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputURLTest extends ActionTest {

    @Test
    public void url入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertURL\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputURL\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputURL\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputURL\", \"inputString\": \"http://localhost:8080/\" } }");
        kubera.action("{ \"actionName\": \"assertURL\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputURL\", \"checkValue\": \"http://localhost:8080/\" } }");
        kubera.action("{ \"actionName\": \"inputURL\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputURL\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertURL\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputURL\", \"checkValue\": \"\" } }");
    }
}
