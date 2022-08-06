package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputSelectArrayTest {
    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @Test
    public void 単一選択に対して親項目を指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"inputSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"selectValue\": \"A\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"A\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"\", \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"inputSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"selectValue\": \"C\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"\", \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"C\", \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArray\", \"checkValue\": \"\", \"index\": 3 } }");

    }

    @Test
    public void 複数選択に対して親項目を指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [], \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [], \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [], \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"inputSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"selectValues\": [\"G\"], \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [], \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [\"G\"], \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [], \"index\": 3 } }");

        kubera.action("{ \"actionName\": \"inputSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"selectValues\": [\"A\", \"B\"], \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [], \"index\": 1 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [\"A\", \"B\", \"G\"], \"index\": 2 } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectArrayMulti\", \"checkValues\": [], \"index\": 3 } }");
    }

}
