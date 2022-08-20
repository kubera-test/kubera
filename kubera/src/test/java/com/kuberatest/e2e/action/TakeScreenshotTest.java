package com.kuberatest.e2e.action;

import com.kuberatest.e2e.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TakeScreenshotTest {
    protected Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @Test
    public void スクリーンショットを撮れること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"takeScreenshot\", "
                + "\"actionJson\": { \"imageFileName\": \"C:\\\\tmp\\\\a.png\" } }");

    }

}