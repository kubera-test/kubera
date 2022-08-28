package io.github.kuberatest.util;

public enum KuberaKey {

    JSON_ACTION_JSON("actionJson"),
    JSON_ACTION_NAME("actionName"),
    JSON_TEST_CASE_NAME("TestCaseName"),
    JSON_TEST_CASES("TestCases"),

    EXCEL_IGNORE_CASE("IgnoreCase"),
    EXCEL_TEST_CASE("TestCase"),
    EXCEL_TEST_CASE_NAME("TestCaseName"),

    LOCATOR_ID("id"),
    LOCATOR_NAME("name"),
    LOCATOR_CSS_SELECTOR("css_selector"),
    LOCATOR_XPATH("xpath"),
    LOCATOR_LINK_TEXT("link_text"),
    LOCATOR_PARTIAL_LINK_TEXT("partial_link_text"),
    LOCATOR_TAG_NAME("tag_name"),
    LOCATOR_CLASS_NAME("class_name");

    private String keyName;

    public String getKeyName() {
        return keyName;
    }

    KuberaKey(String keyName) {
        this.keyName = keyName;
    }
}
