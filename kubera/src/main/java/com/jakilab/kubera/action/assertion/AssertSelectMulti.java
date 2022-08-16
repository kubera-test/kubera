package com.jakilab.kubera.action.assertion;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.jakilab.kubera.action.Action;
import com.jakilab.kubera.action.ObjectAction;
import com.jakilab.kubera.exception.TestFail;
import com.jakilab.kubera.locate.LocateGenerator;
import com.jakilab.kubera.testcasereader.excel.ExcelActionData;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.fail;

public class AssertSelectMulti extends ObjectAction implements Action {

    private String[] checkValues;

    public String[] getCheckValues() {
        return checkValues;
    }

    public void setCheckValues(String[] checkValues) {
        this.checkValues = checkValues;
    }

    @Override
    public void execute() {
        String[] elementValues = elementCollectionToStrings(getSelenideElement().getSelectedOptions());
        Arrays.sort(checkValues);
        Arrays.sort(elementValues);
        Assertions.assertArrayEquals(checkValues, elementValues,
                TestFail.generateFailMessage("対象エレメントの値が一致しません。", Arrays.toString(checkValues), Arrays.toString(elementValues)));
    }

    @Override
    public void validate() {

    }

    @Override
    public void setFromExcel(ExcelActionData excelActionData) {
        setObjectActionDataFromExcel(excelActionData);
        setCheckValues(excelActionData.getTestCase().split("[\\s]*,[\\s]*"));
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
