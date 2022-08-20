package io.github.kuberatest.e2e.action;

import org.junit.jupiter.api.*;

public class InputTextTest extends ActionTest {

    @Test
    public void 単一項目のテキストボックスに対してIDを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"inputString\": \"idを入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"checkValue\": \"idを入力\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"id\", \"searchExpression\": \"idInputText\", \"checkValue\": \"\" } }");

//        kubera.action("{ \"actionName\": \"gotoURL\", "
//                + "\"actionJson\": { \"url\": \"https://google.com/ncr\" } }");
//
//        kubera.action("{ \"actionName\": \"inputTextbox\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='q']\", \"inputString\": \"selenide\" } }");
//        kubera.action("{ \"actionName\": \"inputKey\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='q']\", \"inputKey\": \"Enter\" } }");


//        kubera.action("{ \"actionName\": \"inputTextbox\", "
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

        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"inputString\": \"nameを入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"nameを入力\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"\" } }");
    }

    @Test
    public void 単一項目のテキストボックスに対してClassNameを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"inputString\": \"class nameを入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"checkValue\": \"class nameを入力\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"class_name\", \"searchExpression\": \"classInputText\", \"checkValue\": \"\" } }");
    }

    @Test
    public void 単一項目のテキストボックスに対してCssSelectorを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"inputString\": \"CSS Selectorを入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"checkValue\": \"CSS Selectorを入力\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"checkValue\": \"\" } }");
    }

    @Test
    public void 単一項目のテキストボックスに対してXPathを指定して入力と検証ができること() {

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"checkValue\": \"\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"inputString\": \"xPathを入力\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"checkValue\": \"xPathを入力\" } }");
        kubera.action("{ \"actionName\": \"inputTextbox\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"inputString\": \"\" } }");
        kubera.action("{ \"actionName\": \"assertTextbox\", "
                + "\"actionJson\": { \"locator\": \"xpath\", \"searchExpression\": \"//input[@name='nameInputText']\", \"checkValue\": \"\" } }");
    }
}
