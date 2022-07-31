package com.jakilab.kubera.action;

import com.codeborne.selenide.Selenide;
import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectRadioTest {

    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @Test
    public void ラジオボタンに対してNAMEを指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"selectValue\": \"A\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"A\" } }");
        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"selectValue\": \"B\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"B\" } }");

    }

    @Test
    public void オプションに対してIDを指定して検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioA\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioB\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioC\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"selectValue\": \"A\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioA\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioB\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioC\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"selectValue\": \"B\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioA\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioB\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"checkRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioC\", \"checked\": \"False\" } }");

    }
}
