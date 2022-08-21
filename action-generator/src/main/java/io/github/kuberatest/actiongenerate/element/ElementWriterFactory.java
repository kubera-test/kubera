package io.github.kuberatest.actiongenerate.element;

import io.github.kuberatest.actiongenerate.ElementType;
import io.github.kuberatest.actiongenerate.element.inputtype.Checkbox;
import io.github.kuberatest.actiongenerate.element.inputtype.Radio;
import io.github.kuberatest.actiongenerate.element.inputtype.Textbox;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ElementWriterFactory {
    private static ElementWriterFactory instance;
    private final Map<ElementType, Class<? extends ElementWriter>> elementClassDefinitions = new ConcurrentHashMap<>();

    public synchronized static ElementWriterFactory getInstance() {
        if (instance == null) {
            instance = new ElementWriterFactory();
        }
        return instance;
    }

    protected ElementWriterFactory() {
        elementClassDefinitions.put(ElementType.TEXTBOX, Textbox.class);
        elementClassDefinitions.put(ElementType.RADIO, Radio.class);
        elementClassDefinitions.put(ElementType.CHECKBOX, Checkbox.class);
        elementClassDefinitions.put(ElementType.SELECT, Select.class);
        elementClassDefinitions.put(ElementType.BUTTON, Button.class);
        elementClassDefinitions.put(ElementType.ANCHOR_LINK, AnchorLink.class);
        elementClassDefinitions.put(ElementType.IMG, Img.class);
    }

    public ElementWriter createElementWriter(ElementType elementType) {
        try {
            return elementClassDefinitions.get(elementType).getDeclaredConstructor().newInstance();
            // TODO: 例外の実装
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
