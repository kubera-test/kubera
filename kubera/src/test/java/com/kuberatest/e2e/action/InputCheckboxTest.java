package com.kuberatest.e2e.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class InputCheckboxTest extends ActionTest {

    @Test
    public void チェックボックスに対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckA\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckB\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckC\", \"checked\": \"False\" } }");

        kubera.action("{ \"actionName\": \"inputCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckA\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputCheckA\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputCheckB\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputCheckC\", \"checked\": \"False\" } }");

        kubera.action("{ \"actionName\": \"inputCheckbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputCheckA\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"inputCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckB\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckA\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckB\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckC\", \"checked\": \"False\" } }");

    }

    @Test
    public void 未チェックな項目に対してチェックを期待した場合にFailが発生すること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        Assertions.assertThrows(AssertionFailedError.class,
                () -> kubera.action("{ \"actionName\": \"assertCheckbox\", "
                        + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckA\", \"checked\": \"True\" } }"));
    }

    @Test
    public void チェックされている項目に対して未チェックを期待した場合にFailが発生すること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"inputCheckbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckA\", \"checked\": \"True\" } }");

        Assertions.assertThrows(AssertionFailedError.class,
                () -> kubera.action("{ \"actionName\": \"assertCheckbox\", "
                        + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputCheckA\", \"checked\": \"False\" } }"));
    }
}
