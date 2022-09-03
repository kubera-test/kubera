package io.github.kuberatest.actiongenerate;

import io.github.kuberatest.actiongenerate.writer.stylewriter.element.*;
import io.github.kuberatest.actiongenerate.writer.stylewriter.element.inputtype.*;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.element.*;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.element.inputtype.*;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.*;

public enum ElementType {

    TEXTBOX(new ElementTextbox(), TestcaseTextbox.class, "input[type='text']"),
    RADIO(new ElementRadio(), TestcaseRadio.class, "input[type='radio']"),
    CHECKBOX(new ElementCheckbox(), TestcaseCheckbox.class, "input[type='checkbox']"),
    PASSWORD(new ElementPassword(), TestcasePassword.class, "input[type='password']"),
    FILE(new ElementFile(), TestcaseFile.class, "input[type='file']"),
    SEARCH(new ElementSearch(), TestcaseSearch.class, "input[type='search']"),
    TEL(new ElementTel(), TestcaseTel.class, "input[type='tel']"),
    URL(new ElementUrl(), TestcaseUrl.class, "input[type='url']"),
    EMAIL(new ElementEMail(), TestcaseEMail.class, "input[type='email']"),
    DATE(new ElementDate(), TestcaseDate.class, "input[type='date']"),
    MONTH(new ElementMonth(), TestcaseMonth.class, "input[type='month']"),
    WEEK(new ElementWeek(), TestcaseWeek.class, "input[type='week']"),
    TIME(new ElementTime(), TestcaseTime.class, "input[type='time']"),
    DATETIME_LOCAL(new ElementDatetimeLocal(), TestcaseDatetimeLocal.class, "input[type='datetime-local']"),
    NUMBER(new ElementNumber(), TestcaseNumber.class, "input[type='number']"),
    RANGE(new ElementRange(), TestcaseRange.class, "input[type='range']"),
    COLOR(new ElementColor(), TestcaseColor.class, "input[type='color']"),
    INPUT_BUTTON(new ElementInputButton(), TestcaseInputButton.class, "input[type='button']"),
    INPUT_IMAGE_BUTTON(new ElementInputImageButton(), TestcaseInputImageButton.class, "input[type='image']"),
    INPUT_SUBMIT_BUTTON(new ElementInputSubmitButton(), TestcaseInputSubmitButton.class, "input[type='submit']"),
    INPUT_RESET_BUTTON(new ElementInputResetButton(), TestcaseInputResetButton.class, "input[type='reset']"),

    SELECT(new ElementSelect(), TestcaseSelect.class, "select"),
    TEXTAREA(new ElementTextarea(), TestcaseTextarea.class, "textarea"),
    BUTTON(new ElementButton(), TestcaseButton.class, "button"),
    ANCHOR_LINK(new ElementAnchorLink(), TestcaseAnchorLink.class, "a"),
    IMG(new ElementImg(), TestcaseImg.class, "img");

    private final ElementWriter elementWriter;
    private final Class<? extends TestcaseElementWriter> classLiteral;
    private final String cssSelector;

    ElementType(ElementWriter elementWriter, Class<? extends TestcaseElementWriter> classLiteral, String cssSelector) {
        this.elementWriter = elementWriter;
        this.classLiteral = classLiteral;
        this.cssSelector = cssSelector;
    }

    public ElementWriter getElementWriterInstance() {
        return elementWriter;
    }

    public Class<? extends TestcaseElementWriter> getClassLiteral() {
        return classLiteral;
    }

    public String getCssSelector() {
        return cssSelector;
    }
}
