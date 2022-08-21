package io.github.kuberatest.actiongenerate;

import io.github.kuberatest.actiongenerate.element.*;
import io.github.kuberatest.actiongenerate.element.inputtype.Checkbox;
import io.github.kuberatest.actiongenerate.element.inputtype.Radio;
import io.github.kuberatest.actiongenerate.element.inputtype.Textbox;

public enum ElementType {
    TEXTBOX(new Textbox()),
    RADIO(new Radio()),
    CHECKBOX(new Checkbox()),
    SELECT(new Select()),
    BUTTON(new Button()),
    ANCHOR_LINK(new AnchorLink()),
    IMG(new Img());

    private ElementWriterIndependentOfData elementWriter;
    private ElementType(ElementWriterIndependentOfData elementWriter) {
        this.elementWriter = elementWriter;
    }

    public ElementWriterIndependentOfData getElementWriter() {
        return elementWriter;
    }
}
