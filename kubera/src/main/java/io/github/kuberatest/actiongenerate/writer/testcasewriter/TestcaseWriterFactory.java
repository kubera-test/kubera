package io.github.kuberatest.actiongenerate.writer.testcasewriter;

import io.github.kuberatest.actiongenerate.BeforeActionType;
import io.github.kuberatest.actiongenerate.ElementType;
import io.github.kuberatest.actiongenerate.NormalActionType;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestcaseWriterFactory {
    private static TestcaseWriterFactory instance;
    private final Map<ElementType, Class<? extends TestcaseElementWriter>> elementClassDefinitions = new HashMap<>();
    private final Map<BeforeActionType, Class<? extends TestcaseActionWriter>> beforeActionClassDefinitions = new HashMap<>();
    private final Map<NormalActionType, Class<? extends TestcaseActionWriter>> normalActionClassDefinitions = new HashMap<>();

    public synchronized static TestcaseWriterFactory getInstance() {
        if (instance == null) {
            instance = new TestcaseWriterFactory();
        }
        return instance;
    }

    protected TestcaseWriterFactory() {
        Arrays.stream(ElementType.values())
                .forEach(type -> elementClassDefinitions.put(type, type.getClassLiteral()));
        Arrays.stream(BeforeActionType.values())
                .forEach(type -> beforeActionClassDefinitions.put(type, type.getClassLiteral()));
        Arrays.stream(NormalActionType.values())
                .forEach(type -> normalActionClassDefinitions.put(type, type.getClassLiteral()));
    }

    public TestcaseElementWriter createElementWriter(ElementType elementType) {
        try {
            return elementClassDefinitions.get(elementType).getDeclaredConstructor().newInstance();
            // TODO: 例外の実装
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public TestcaseActionWriter createActionWriter(NormalActionType normalActionType) {
        try {
            return normalActionClassDefinitions.get(normalActionType).getDeclaredConstructor().newInstance();
            // TODO: 例外の実装
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public TestcaseActionWriter createBeforeActionWriter(BeforeActionType beforeActionType) {
        try {
            return beforeActionClassDefinitions.get(beforeActionType).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}