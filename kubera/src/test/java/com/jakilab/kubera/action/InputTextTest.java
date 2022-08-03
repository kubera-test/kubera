package com.jakilab.kubera.action;

import com.jakilab.kubera.Kubera;

import org.junit.jupiter.api.*;

public class InputTextTest {

    private Kubera kubera;

    @BeforeEach
    public void setUp() {
        kubera = new Kubera();
    }

    @Test
    public void 単一項目のテキストボックスに対してIDを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"inputString\": \"idを入力\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"checkValue\": \"idを入力\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"checkValue\": \"\" } }");

//        kubera.action("{ \"actionName\": \"gotoURL\", "
//                + "\"actionJson\": { \"url\": \"https://google.com/ncr\" } }");
//
//        kubera.action("{ \"actionName\": \"inputText\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='q']\", \"inputString\": \"selenide\" } }");
//        kubera.action("{ \"actionName\": \"inputKey\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='q']\", \"inputKey\": \"Enter\" } }");


//        kubera.action("{ \"actionName\": \"inputText\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"inputString\": \"selenide\" } }");
        // Arrange
//        kubera.action("https://google.com/ncr");
//        // Act
//        new GoogleSearch().searchFor("selenide");
//
//        // Assert
//        SearchResults results = new SearchResults();
//        results.found.shouldHave(sizeGreaterThan(1));
//        results.getResult(0).shouldHave(text("Selenide: concise UI tests in Java"));
    }

    @Test
    public void 単一項目のテキストボックスに対してNAMEを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"inputString\": \"nameを入力\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"nameを入力\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"\" } }");
    }

    @Test
    public void 単一項目のテキストボックスに対してClassNameを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"inputString\": \"class nameを入力\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"checkValue\": \"class nameを入力\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"checkValue\": \"\" } }");
    }

    @Test
    public void 単一項目のテキストボックスに対してCssSelectorを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"inputString\": \"CSS Selectorを入力\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"checkValue\": \"CSS Selectorを入力\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"checkValue\": \"\" } }");
    }

    @Test
    public void 単一項目のテキストボックスに対してXPathを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"inputString\": \"xPathを入力\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"checkValue\": \"xPathを入力\" } }");
        kubera.action("{ \"actionName\": \"inputText\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertText\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"checkValue\": \"\" } }");
    }
}
