package io.github.kuberatest.actiongenerate;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseActionWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.action.TestcaseGoToURL;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.action.TestcaseSwitchTo;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.action.TestcaseTakeScreenshot;

public enum NormalActionType {

    GO_TO_URL(TestcaseGoToURL.class),
    SWITCH_TO(TestcaseSwitchTo.class),
    TAKE_SCREENSHOT(TestcaseTakeScreenshot.class);

    private final Class<? extends TestcaseActionWriter> classLiteral;

    NormalActionType(Class<? extends TestcaseActionWriter> classLiteral) {
        this.classLiteral = classLiteral;
    }

    public Class<? extends TestcaseActionWriter> getClassLiteral() {
        return classLiteral;
    }
}
