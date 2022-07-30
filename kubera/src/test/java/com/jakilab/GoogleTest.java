package com.jakilab;

import com.jakilab.kubera.Kubera;
import com.jakilab.pagewidgets.*;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Simple Selenide Test with PageObjects
 */
public class GoogleTest

{
    @Test
    public void searchForSelenide() {
        Kubera kubera = new Kubera();
//        kubera.action("{ \"actionName\": \"gotoURL\", "
//                + "\"actionJson\": { \"url\": \"https://google.com/ncr\" } }");
//
//        kubera.action("{ \"actionName\": \"inputString\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='q']\", \"inputString\": \"selenide\" } }");
//        kubera.action("{ \"actionName\": \"inputKey\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='q']\", \"inputKey\": \"Enter\" } }");

        kubera.action("{ \"actionName\": \"gotoURL\", "
                + "\"actionJson\": { \"url\": \"http://localhost:8080/input\" } }");

        kubera.action("{ \"actionName\": \"checkValue\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"\" } }");
//        kubera.action("{ \"actionName\": \"inputString\", "
//                + "\"actionJson\": { \"locator\": \"css_selector\", \"searchExpression\": \"input[name='nameInputText']\", \"inputString\": \"selenide\" } }");
        kubera.action("{ \"actionName\": \"inputString\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"inputString\": \"selenide\" } }");
        kubera.action("{ \"actionName\": \"checkValue\", "
                + "\"actionJson\": { \"locator\": \"name\", \"searchExpression\": \"nameInputText\", \"checkValue\": \"selenide\" } }");
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
}
