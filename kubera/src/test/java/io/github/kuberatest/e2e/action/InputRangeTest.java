package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputRangeTest extends ActionTest {

    @Test
    public void 範囲バー入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertRange\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRange\", \"checkValue\": \"0\" } }");
        kubera.action("{ \"actionName\": \"inputRange\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRange\", \"inputString\": \"90\" } }");
        kubera.action("{ \"actionName\": \"assertRange\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRange\", \"checkValue\": \"90\" } }");
    }
}
