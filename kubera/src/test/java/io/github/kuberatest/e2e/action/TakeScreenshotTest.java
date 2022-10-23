package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.Test;

public class TakeScreenshotTest extends ActionTest {

    @Test
    public void スクリーンショットを撮れること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"https://www.selenium.dev/ja/\" } }");

        kubera.action("{ \"actionName\": \"takeScreenshot\", "
                + "\"actionJson\": { \"imageFileName\": \"a.png\" } }");

    }

}