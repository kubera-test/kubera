package io.github.kuberatest.e2e.action;

import io.github.kuberatest.e2e.action.assertion.*;
import io.github.kuberatest.e2e.action.clear.*;
import io.github.kuberatest.e2e.action.click.*;
import io.github.kuberatest.e2e.action.input.*;
import io.github.kuberatest.e2e.action.screenshot.TakeScreenshot;
import io.github.kuberatest.e2e.action.status.IsEmpty;
import io.github.kuberatest.e2e.action.status.IsEnable;
import io.github.kuberatest.e2e.action.status.IsVisible;

public enum ActionType {

    // ----------------------------------------------- Page
    GOTO_URL("gotoURL", GoToURL.class),

    // ---------------------------------------------- Input
    INPUT_TEXTBOX("inputTextbox", InputTextbox.class),
    CLEAR_TEXTBOX("clearTextbox", ClearTextbox.class),
    ASSERT_TEXTBOX("assertTextbox", AssertTextbox.class),

    INPUT_PASSWORD("inputPassword", InputPassword.class),
    CLEAR_PASSWORD("clearPassword", ClearPassword.class),
    ASSERT_PASSWORD("assertPassword", AssertPassword.class),

    SELECT_RADIO("selectRadio", SelectRadio.class),
    ASSERT_RADIO("assertRadio", AssertRadio.class),

    INPUT_CHECKBOX("inputCheckbox", InputCheckbox.class),
    CLEAR_CHECKBOX("clearCheckbox", ClearCheckbox.class),
    ASSERT_CHECKBOX("assertCheckbox", AssertCheckbox.class),

    INPUT_SELECT("inputSelect", InputSelect.class),
    CLEAR_SELECT("clearSelect", ClearSelect.class),
    ASSERT_SELECT("assertSelect", AssertSelect.class),
    INPUT_SELECT_MULTI("inputSelectMulti", InputSelectMulti.class),
    CLEAR_SELECT_MULTI("clearSelectMulti", ClearSelectMulti.class),
    ASSERT_SELECT_MULTI("assertSelectMulti", AssertSelectMulti.class),

    INPUT_TEXTAREA("inputTextarea", InputTextarea.class),
    CLEAR_TEXTAREA("clearTextarea", ClearTextarea.class),
    ASSERT_TEXTAREA("assertTextarea", AssertTextarea.class),

    INPUT_FILE("inputFile", InputFile.class),
    CLEAR_FILE("clearFile", ClearFile.class),
    ASSERT_FILE("assertFile", AssertFile.class),

    INPUT_SEARCH("inputSearch", InputSearch.class),
    CLEAR_SEARCH("clearSearch", ClearSearch.class),
    ASSERT_SEARCH("assertSearch", AssertSearch.class),

    INPUT_TEL("inputTel", InputTel.class),
    CLEAR_TEL("clearTel", ClearTel.class),
    ASSERT_TEL("assertTel", AssertTel.class),

    INPUT_URL("inputURL", InputURL.class),
    CLEAR_URL("clearURL", ClearURL.class),
    ASSERT_URL("assertURL", AssertURL.class),

    INPUT_EMAIL("inputEMail", InputEMail.class),
    CLEAR_EMAIL("clearEMail", ClearEMail.class),
    ASSERT_EMAIL("assertEMail", AssertEMail.class),

    INPUT_DATE("inputDate", InputDate.class),
    CLEAR_DATE("clearDate", ClearDate.class),
    ASSERT_DATE("assertDate", AssertDate.class),

    INPUT_MONTH("inputMonth", InputMonth.class),
    CLEAR_MONTH("clearMonth", ClearMonth.class),
    ASSERT_MONTH("assertMonth", AssertMonth.class),

    INPUT_WEEK("inputWeek", InputWeek.class),
    CLEAR_WEEK("clearWeek", ClearWeek.class),
    ASSERT_WEEK("assertWeek", AssertWeek.class),

    INPUT_TIME("inputTime", InputTime.class),
    CLEAR_TIME("clearTime", ClearTime.class),
    ASSERT_TIME("assertTime", AssertTime.class),

    INPUT_DATETIME_LOCAL("inputDatetimeLocal", InputDatetimeLocal.class),
    CLEAR_DATETIME_LOCAL("clearDatetimeLocal", ClearDatetimeLocal.class),
    ASSERT_DATETIME_LOCAL("assertDatetimeLocal", AssertDatetimeLocal.class),

    INPUT_NUMBER("inputNumber", InputNumber.class),
    CLEAR_NUMBER("clearNumber", ClearNumber.class),
    ASSERT_NUMBER("assertNumber", AssertNumber.class),

    INPUT_RANGE("inputRange", InputRange.class),
    ASSERT_RANGE("assertRange", AssertRange.class),

    INPUT_COLOR("inputColor", InputColor.class),
    ASSERT_COLOR("assertColor", AssertColor.class),

    CLICK_INPUT_BUTTON("clickInputButton", ClickInputButton.class),
    CLICK_INPUT_IMAGE_BUTTON("clickInputImageButton", ClickInputImageButton.class),
    CLICK_INPUT_SUBMIT_BUTTON("clickInputSubmitButton", ClickInputSubmitButton.class),
    CLICK_INPUT_RESET_BUTTON("clickInputResetButton", ClickInputResetButton.class),

    // --------------------------------------------- Button
    CLICK_BUTTON("clickButton", ClickButton.class),

    // -------------------------------------------------- A
    CLICK_LINK("clickLink", ClickLink.class),

    // ------------------------------------------------ Img
    CLICK_IMAGE("clickImage", ClickImage.class),

    // ------------------------------------------- Keyboard
    INPUT_KEY("inputKey", InputKey.class),

    // ---------------------------------------------- Label
    ASSERT_TEXT("assertText", AssertText.class),

    // ----------------------------------------- Screenshot
    TAKE_SCREENSHOT("takeScreenshot", TakeScreenshot.class),

    // --------------------------------------------- Status
    IS_VISIBLE("isVisible", IsVisible.class),
    IS_ENABLE("isEnable", IsEnable.class),
    IS_EMPTY("isEmpty", IsEmpty.class);

    private final String key;
    private final Class<? extends Action> aClass;

    ActionType(String key, Class<? extends Action> aClass) {
        this.key = key;
        this.aClass = aClass;
    }

    public String getKey() {
        return key;
    }

    public Class<? extends Action> getaClass() {
        return aClass;
    }
}
