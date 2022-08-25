package io.github.kuberatest.e2e.locate;

import org.openqa.selenium.By;

public interface Locator {
    By by(String searchExpression);
}
