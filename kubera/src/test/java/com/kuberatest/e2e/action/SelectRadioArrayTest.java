package com.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class SelectRadioArrayTest extends ActionTest {

    @Test
    public void ラジオボタンに対して配列要素番号を指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayA\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayB\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayC\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayA\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayB\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayC\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayA\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayB\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayC\", \"checked\": \"False\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadioArray\", \"selected\": \"True\", \"index\": 5 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayA\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayB\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayC\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayA\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayB\", \"checked\": \"True\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayC\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayA\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayB\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioArrayC\", \"checked\": \"False\", \"index\": 3 } }");

    }
}
