package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TakeScreenshotTest {
    protected Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @Test
    public void ラジオボタンに対してNAMEを指定して入力と検証ができること() {
        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"takeScreenshot\", "
                + "\"actionJson\": { \"imageFileName\": \"C:\\\\tmp\\\\a.png\" } }");

    }

}