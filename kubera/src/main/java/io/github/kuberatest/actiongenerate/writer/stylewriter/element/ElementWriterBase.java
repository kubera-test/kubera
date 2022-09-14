package io.github.kuberatest.actiongenerate.writer.stylewriter.element;

import io.github.kuberatest.actiongenerate.ElementType;
import io.github.kuberatest.actiongenerate.writer.stylewriter.StyleWriterBase;
import io.github.kuberatest.util.KuberaKey;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

public abstract class ElementWriterBase extends StyleWriterBase implements ElementWriter {

    @Override
    public String[] getElementAttribute(WebElement element, ElementType elementType) {
        String attrName = element.getAttribute("name");
        if (attrName != null && attrName.trim().length() != 0) {
            return Stream.of(KuberaKey.LOCATOR_NAME.getKeyName(), attrName).toArray(String[]::new);
        }
        String attrId = element.getAttribute("id");
        if (attrId != null && attrId.trim().length() != 0) {
            return Stream.of(KuberaKey.LOCATOR_ID.getKeyName(), attrId).toArray(String[]::new);
        }
        return Stream.of(KuberaKey.LOCATOR_CSS_SELECTOR.getKeyName(), String.format(elementType.getCssSelector())).toArray(String[]::new);
    }
}
