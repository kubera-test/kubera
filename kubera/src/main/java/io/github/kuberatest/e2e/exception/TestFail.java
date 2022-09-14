package io.github.kuberatest.e2e.exception;

import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;
import org.junit.jupiter.api.Assertions;

public class TestFail {

    public static void fail(String message, String expected, String actual) {
        // TODO: MessageKeyを受け取る版のメソッドも作成する
        Assertions.fail(generateFailMessage(message, expected, actual));
    }

    public static void fail(String message) {
        Assertions.fail(message);
    }

    public static void fail(MessageKey messageKey, Object... args) {
        fail(Messages.getMessage(messageKey, args));
    }

    public static String generateFailMessage(String message, String expected, String actual) {
        return Messages.getMessage(MessageKey.FAIL_MESSAGE_FORMAT, message, expected, actual);
    }
}
