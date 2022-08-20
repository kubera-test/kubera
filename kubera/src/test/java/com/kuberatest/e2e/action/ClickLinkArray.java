package com.kuberatest.e2e.action;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClickLinkArray extends ActionTest {

    @Test
    public void ボタンをクリックできること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"clickLink\", "
                + "\"actionJson\": { \"locator\": \"link_text\", \"searchExpression\": \"リンク配列\", \"index\": 2 } }");

        // TODO: ダイアログ操作系を実装したら修正
        String msg = Selenide.confirm();
        assertTrue(msg.equals("1"));
    }
}
