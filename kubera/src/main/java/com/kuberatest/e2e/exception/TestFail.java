package com.kuberatest.e2e.exception;

import org.junit.jupiter.api.Assertions;

public class TestFail {

    public static void fail(String message, String expected, String actual) {
        Assertions.fail(generateFailMessage(message, expected, actual));
    }

    public static void fail(String message) {
        Assertions.fail(message);
    }

    public static String generateFailMessage(String message, String expected, String actual) {
        return String.format(message + "\n期待値:%s\n実際の値:%s", expected, actual);
    }
}
