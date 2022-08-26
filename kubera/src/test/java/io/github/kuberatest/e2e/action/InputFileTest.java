package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputFileTest extends ActionTest {
    @Test
    public void ファイルに対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertFile\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputFile\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputFile\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputFile\", \"fileName\": \"/json/json-array.json\" } }");
        kubera.action("{ \"actionName\": \"assertFile\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputFile\", \"checkValue\": \"json-array.json\" } }");

        kubera.action("{ \"actionName\": \"clearFile\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputFile\" } }");
        kubera.action("{ \"actionName\": \"assertFile\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputFile\", \"checkValue\": \"\" } }");
    }
}
