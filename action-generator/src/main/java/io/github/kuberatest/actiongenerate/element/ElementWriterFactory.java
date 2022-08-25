package io.github.kuberatest.actiongenerate.element;

import io.github.kuberatest.actiongenerate.ElementType;
import io.github.kuberatest.actiongenerate.element.inputtype.Checkbox;
import io.github.kuberatest.actiongenerate.element.inputtype.Radio;
import io.github.kuberatest.actiongenerate.element.inputtype.Textbox;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
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
        Arrays.stream(ElementType.values())
                .forEach(type -> elementClassDefinitions.put(type, type.getClassLiteral()));
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
