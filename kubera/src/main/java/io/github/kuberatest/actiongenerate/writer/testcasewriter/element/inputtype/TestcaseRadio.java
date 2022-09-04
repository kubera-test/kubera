package io.github.kuberatest.actiongenerate.writer.testcasewriter.element.inputtype;

import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriter;
import io.github.kuberatest.actiongenerate.writer.testcasewriter.TestcaseElementWriterBase;
import io.github.kuberatest.e2e.action.ActionType;
import io.github.kuberatest.util.excelform.ExcelKey;
import io.github.kuberatest.util.excelform.ExcelForms;

public class TestcaseRadio extends TestcaseElementWriterBase implements TestcaseElementWriter {
    @Override
    public int writeExcel() {
        String elementName = getElementLabel(ExcelKey.OBJECT_RADIO);
        writeTestcase(elementName);
        return activeRow;
    }

    private void writeTestcase(String elementName) {
        if (arrayCount != null && arrayCount == 1) {
            writeSelectRadio(elementName);
            writeAssertRadio(elementName);
        }
        writeIsVisible(elementName);
        writeIsEnabled(elementName);
    }

    /**
     * ラジオボタンを選択します。
     * ラジオボタンの場合は、配列要素であっても配列のインデックスを指定する必要はないので、ここで明示的にnullを指定します。
     * @param elementName 要素名
     */
    private void writeSelectRadio(String elementName) {
        writeTestcase(ActionType.SELECT_RADIO.getKey(),
                ExcelForms.getMessage(ExcelKey.TESTCASE_UNCHECK_VALUE, elementName),
                null);
    }

    /**
     * ラジオボタンを検証します。
     * ラジオボタンの場合は、配列要素であっても配列のインデックスを指定する必要はないので、ここで明示的にnullを指定します。
     * @param elementName 要素名
     */
    private void writeAssertRadio(String elementName) {
        writeTestcase(ActionType.ASSERT_RADIO.getKey(),
                ExcelForms.getMessage(ExcelKey.TESTCASE_ASSERT_VALUE, elementName),
                null);
    }
}
