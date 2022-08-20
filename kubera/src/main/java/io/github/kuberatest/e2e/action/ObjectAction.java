package io.github.kuberatest.e2e.action;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.github.kuberatest.e2e.locate.LocateGenerator;
import io.github.kuberatest.e2e.testcasereader.excel.ExcelActionData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ObjectAction extends TestCaseAction implements Action {
    private String locator;
    private String searchExpression;
    private Integer index;

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

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setObjectActionDataFromExcel(ExcelActionData excelActionData) {
        setTestCaseActionDataFromExcel(excelActionData);
        setLocator(excelActionData.getLocator());
        setSearchExpression(excelActionData.getSearchExpression());
        setIndex(excelActionData.getIndex());
    }

    protected boolean isInputIndex() {
        return index != null;
    }

    protected SelenideElement getSelenideElement() {
        if (isInputIndex()) {
            return Selenide.$$(LocateGenerator.getInstance().getLocator(getLocator(), getSearchExpression())).get(getIndex() - 1);
        } else {
            return Selenide.$(LocateGenerator.getInstance().getLocator(getLocator(), getSearchExpression()));
        }
    }

    protected boolean isCheckedString(String value) {
        final List<String> checkedString = new ArrayList<>(Arrays.asList("TRUE", "True", "true", "〇", "check", "*", "v", "V"));
        if (checkedString.contains(value)) {
            return true;
        }
        return false;
    }

    protected Boolean isVisibleString(String value) {
        final List<String> checkedString = new ArrayList<>(Arrays.asList("TRUE", "True", "true", "表示`"));
        if (checkedString.contains(value)) {
            return true;
        } else if (isInvisibleString(value)) {
            return false;
        }
        return null;
    }

    protected Boolean isInvisibleString(String value) {
        final List<String> checkedString = new ArrayList<>(Arrays.asList("FALSE", "False", "false", "非表示`"));
        if (checkedString.contains(value)) {
            return true;
        }
        return false;
    }
}
