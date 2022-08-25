package io.github.kuberatest.actiongenerate;

import io.github.kuberatest.actiongenerate.element.*;
import io.github.kuberatest.actiongenerate.element.inputtype.*;
import io.github.kuberatest.actiongenerate.element.inputtype.Number;

public enum ElementType {
    // TODO: 左と右で用途が異なるので、クラスを分けて管理するように検討
    TEXTBOX(new Textbox(), Textbox.class),
    RADIO(new Radio(), Radio.class),
    CHECKBOX(new Checkbox(), Checkbox.class),
    PASSWORD(new Password(), Password.class),
    FILE(new File(), File.class),
    SEARCH(new Search(), Search.class),
    TEL(new Tel(), Tel.class),
    URL(new Url(), Url.class),
    EMAIL(new EMail(), EMail.class),
    DATE(new Date(), Date.class),
    MONTH(new Month(), Month.class),
    WEEK(new Week(), Week.class),
    TIME(new Time(), Time.class),
    DATETIME_LOCAL(new DatetimeLocal(), DatetimeLocal.class),
    NUMBER(new Number(), Number.class),
    RANGE(new Range(), Range.class),
    COLOR(new Color(), Color.class),
    INPUT_BUTTON(new InputButton(), InputButton.class),
    INPUT_IMAGE_BUTTON(new InputImageButton(), InputImageButton.class),
    INPUT_SUBMIT_BUTTON(new InputSubmitButton(), InputSubmitButton.class),
    INPUT_RESET_BUTTON(new InputResetButton(), InputResetButton.class),

    SELECT(new Select(), Select.class),
    TEXTAREA(new Textarea(), Textarea.class),
    BUTTON(new Button(), Button.class),
    ANCHOR_LINK(new AnchorLink(), AnchorLink.class),
    IMG(new Img(), Img.class);

    private final ElementWriterIndependentOfData elementWriter;
    private final Class<? extends ElementWriter> classLiteral;
    ElementType(ElementWriterIndependentOfData elementWriter, Class<? extends ElementWriter> classLiteral) {
        this.elementWriter = elementWriter;
        this.classLiteral = classLiteral;
    }

    public ElementWriterIndependentOfData getElementWriterInstance() {
        return elementWriter;
    }

    public Class<? extends ElementWriter> getClassLiteral() {
        return classLiteral;
    }
}
