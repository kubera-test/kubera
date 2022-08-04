package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.locate.LocateGenerator;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.fail;

public class AssertSelectMulti implements Action {

    private String locator;
    private String searchExpression;
    private String[] checkValues;

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

    @Override
    public void execute() {
        String[] elementValues = elementCollectionToStrings(Selenide.$(LocateGenerator.getInstance().getLocator(locator, searchExpression)).getSelectedOptions());
        Arrays.sort(checkValues);
        Arrays.sort(elementValues);
        if (!Arrays.equals(checkValues, elementValues, (o1, o2) -> o1.compareTo(o2))) {
            fail(String.format("一致しません。\n期待値:[%s]実際の値:[%s]", Arrays.toString(checkValues), Arrays.toString(elementValues)));
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
