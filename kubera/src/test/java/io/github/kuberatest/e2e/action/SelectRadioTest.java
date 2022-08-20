package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

public class SelectRadioTest extends ActionTest {

    @Test
    public void ラジオボタンに対してNAMEを指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"selectValue\": \"A\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"A\" } }");
        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"selectValue\": \"B\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"B\" } }");

    }

    @Test
    public void オプションに対してIDを指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioA\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioB\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioC\", \"checked\": \"False\" } }");

        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioA\", \"selected\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioA\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioB\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioC\", \"checked\": \"False\" } }");

        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioB\", \"selected\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioA\", \"checked\": \"False\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioB\", \"checked\": \"True\" } }");
        kubera.action("{ \"actionName\": \"assertRadio\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputRadioC\", \"checked\": \"False\" } }");

    }

    @Test
    public void 対象エレメントが期待値と一致しない場合Failが発生すること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"selectRadio\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"selectValue\": \"A\" } }");
        Assertions.assertThrows(AssertionFailedError.class,
                () -> kubera.action("{ \"actionName\": \"assertRadio\", "
                        + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"B\" } }"));
    }

    @Test
    public void 対象エレメントが未選択な状態で期待値と一致しない場合Failが発生すること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        Assertions.assertThrows(AssertionFailedError.class,
                () -> kubera.action("{ \"actionName\": \"assertRadio\", "
                        + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputRadio\", \"checkValue\": \"A\" } }"));
    }
}
