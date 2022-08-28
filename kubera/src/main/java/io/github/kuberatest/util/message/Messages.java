package io.github.kuberatest.util.message;

import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

    private static final ResourceBundle propertyResourceBundle;

    static {
        propertyResourceBundle =
                ResourceBundle.getBundle(
                        "Message",
                        Locale.getDefault(),
                        new URLClassLoader(
                                new URL[]{Messages.class.getResource("")}));
    }

    public static String getMessage(MessageKey key, Object... args) {
        String message = propertyResourceBundle.getString(key.name());
        return MessageFormat.format(message, args);
    }
}
