package io.github.kuberatest.util;

import io.github.kuberatest.util.message.MessageKey;
import io.github.kuberatest.util.message.Messages;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessagesTest {
    @Test
    public void messageプロパティからパラメータ無しで取得できること() {
        assertEquals("テキストボックス", Messages.getMessage(MessageKey.TAG_TEXTBOX));
    }
}
