package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputCheckboxArrayTest extends ActionTest {

    @Test
    public void チェックボックスに対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"inputCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"True\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"True\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"inputCheckbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputCheckArrayA\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"inputCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"True\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"True\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayA\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayB\", \"checked\": \"False\", \"index\": 3 } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckArrayC\", \"checked\": \"False\", \"index\": 3 } }");

    }
}
