package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SelectRadioArrayTest {
    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @Test
    public void ラジオボタンの検証に対してインデックスを入力したらエラーになること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        try {
            kubera.action("{ \"actionName\": \"assertRadio\", "
                    + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadioArray\", \"checkValue\": \"\", \"index\": 1 } }");
        } catch (Throwable e) {
            Assertions.assertEquals("ラジオボタンには配列要素番号を指定できません。", e.getMessage());
            return;
        }
        Assertions.fail("エラーが発生しなかった");

    }

    @Test
    public void ラジオボタンの入力に対してインデックスを入力したらエラーになること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        try {
            kubera.action("{ \"actionName\": \"selectRadio\", "
                    + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadioArray\", \"selectValue\": \"A\", \"index\": 2 } }");
        } catch (Throwable e) {
            Assertions.assertEquals("ラジオボタンには配列要素番号を指定できません。", e.getMessage());
            return;
        }
        Assertions.fail("エラーが発生しなかった");
    }
}
