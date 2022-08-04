package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    }
}
