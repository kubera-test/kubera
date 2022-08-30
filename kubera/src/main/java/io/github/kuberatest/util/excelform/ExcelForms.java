package io.github.kuberatest.util.excelform;

import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ExcelForms {

    private static final ResourceBundle propertyResourceBundle;

    static {
        propertyResourceBundle =
                ResourceBundle.getBundle(
                        "ExcelForm",
                        Locale.getDefault(),
                        new URLClassLoader(
                                new URL[]{ExcelForms.class.getResource("")}));
    }

    public static String getMessage(ExcelKey key, Object... args) {
        String message = propertyResourceBundle.getString(key.name());
        return MessageFormat.format(message, args);
    }
}
