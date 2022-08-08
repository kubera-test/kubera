package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class InputSelectTest {

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
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelect\", \"checkValue\": \"\" } }");

        kubera.action("{ \"actionName\": \"inputSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelect\", \"selectValue\": \"A\" } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelect\", \"checkValue\": \"A\" } }");

        kubera.action("{ \"actionName\": \"inputSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelect\", \"selectValue\": \"C\" } }");
        kubera.action("{ \"actionName\": \"assertSelect\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelect\", \"checkValue\": \"C\" } }");

    }

    @Test
    public void 複数選択に対して親項目を指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"checkValues\": [] } }");

        kubera.action("{ \"actionName\": \"inputSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"selectValues\": [\"G\"] } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"checkValues\": [\"G\"] } }");

        kubera.action("{ \"actionName\": \"inputSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"selectValues\": [\"A\", \"B\"] } }");
        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"checkValues\": [\"G\", \"B\", \"A\"] } }");
    }

    @Test
    public void 対象エレメントと期待値が異なる場合Failが発生すること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"checkValues\": [] } }");

        kubera.action("{ \"actionName\": \"inputSelectMulti\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"selectValues\": [\"G\", \"B\"] } }");
        Assertions.assertThrows(AssertionFailedError.class,
                () -> kubera.action("{ \"actionName\": \"assertSelectMulti\", "
                        + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputSelectMulti\", \"checkValues\": [\"A\", \"B\"] } }"));
    }
}
