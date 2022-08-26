package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class InputEMailTest extends ActionTest {

    @Test
    public void email入力項目に対して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertEMail\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputEMail\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputEMail\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputEMail\", \"inputString\": \"e.mail@kubera.com\" } }");
        kubera.action("{ \"actionName\": \"assertEMail\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputEMail\", \"checkValue\": \"e.mail@kubera.com\" } }");
        kubera.action("{ \"actionName\": \"clearEMail\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputEMail\" } }");
        kubera.action("{ \"actionName\": \"assertEMail\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputEMail\", \"checkValue\": \"\" } }");
    }
}
