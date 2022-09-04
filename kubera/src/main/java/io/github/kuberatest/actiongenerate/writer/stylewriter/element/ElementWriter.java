package io.github.kuberatest.actiongenerate.writer.stylewriter.element;

import io.github.kuberatest.actiongenerate.ElementType;
import io.github.kuberatest.actiongenerate.writer.stylewriter.StyleWriter;
import org.openqa.selenium.WebElement;

public interface ElementWriter extends StyleWriter {
    String[] getElementAttribute(WebElement element, ElementType elementType);
}
