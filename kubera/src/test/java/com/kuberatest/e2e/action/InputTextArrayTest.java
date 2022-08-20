package com.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputTextArrayTest extends ActionTest {

    @Test
    public void 配列項目のテキストボックスに対してIDとインデックスを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextArray\", \"checkValue\": \"\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextArray\", \"checkValue\": \"\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextArray\", \"inputString\": \"idを入力\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextArray\", \"checkValue\": \"idを入力\", \"index\": 2 } }");

        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextArray\", \"inputString\": \"\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputTextArray\", \"checkValue\": \"\", \"index\": 2 } }");
    }

}
