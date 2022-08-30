package io.github.kuberatest.actiongenerate.element.testcasewriter;

import io.github.kuberatest.actiongenerate.ElementType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestcaseWriterFactory {
    private static TestcaseWriterFactory instance;
    private final Map<ElementType, Class<? extends TestcaseWriter>> elementClassDefinitions = new ConcurrentHashMap<>();

    public synchronized static TestcaseWriterFactory getInstance() {
        if (instance == null) {
            instance = new TestcaseWriterFactory();
        }
        return instance;
    }

    protected TestcaseWriterFactory() {
        Arrays.stream(ElementType.values())
                .forEach(type -> elementClassDefinitions.put(type, type.getClassLiteral()));
    }

    public TestcaseWriter createElementWriter(ElementType elementType) {
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
