package io.github.kuberatest.actiongenerate;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseActionWriter;

public enum BeforeActionType {
    ;

    private final Class<? extends TestcaseActionWriter> classLiteral;

    BeforeActionType(Class<? extends TestcaseActionWriter> classLiteral) {
        this.classLiteral = classLiteral;
    }

    public Class<? extends TestcaseActionWriter> getClassLiteral() {
        return classLiteral;
    }
}
