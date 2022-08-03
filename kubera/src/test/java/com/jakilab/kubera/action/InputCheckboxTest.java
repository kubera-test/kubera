package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputCheckboxTest {

    private Kubera kubera;
    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

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

}
