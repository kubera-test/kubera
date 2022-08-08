package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.exception.TestFail;
import com.jakilab.kubera.locate.LocateGenerator;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.fail;

public class AssertSelectMulti implements Action {

    private String locator;
    private String searchExpression;
    private String[] checkValues;
    private int index = 0;

    public String getLocator() {
        return locator;
    }

    public void setLocator(String locator) {
        this.locator = locator;
    }

    public String getSearchExpression() {
        return searchExpression;
    }

    public void setSearchExpression(String searchExpression) {
        this.searchExpression = searchExpression;
    }

    public String[] getCheckValues() {
        return checkValues;
    }

    public void setCheckValues(String[] checkValues) {
        this.checkValues = checkValues;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void execute() {
        String[] elementValues = elementCollectionToStrings(getSelectedOptions());
        Arrays.sort(checkValues);
        Arrays.sort(elementValues);
        Assertions.assertArrayEquals(checkValues, elementValues,
                TestFail.generateFailMessage("対象エレメントの値が一致しません。", Arrays.toString(checkValues), Arrays.toString(elementValues)));
    }

    @Override
    public void validate() {

    }

    private ElementsCollection getSelectedOptions() {
        if (index == 0) {
            return Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).getSelectedOptions();
        } else {
            return Selenide.$$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).get(index - 1).getSelectedOptions();
        }
    }

    private String[] elementCollectionToStrings(ElementsCollection elementsCollection) {
        String[] elementValues = new String[elementsCollection.size()];
        int elementIndex = 0;
        for(SelenideElement element : elementsCollection) {
            elementValues[elementIndex++] = element.getValue();
        }
        return elementValues;
    }
}
