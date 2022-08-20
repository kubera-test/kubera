package com.kuberatest.e2e.locate;

import org.openqa.selenium.By;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LocateGenerator {

    private static LocateGenerator instance;

    private final Map<String, Locator> locatorClassDefinitions = new ConcurrentHashMap<>();

    public static synchronized LocateGenerator getInstance() {
        if (instance == null) {
            instance = new LocateGenerator();
        }
        return instance;
    }

    protected LocateGenerator() {
        locatorClassDefinitions.put("id", new IdLocator());
        locatorClassDefinitions.put("name", new NameLocator());
        locatorClassDefinitions.put("css_selector", new CssSelectorLocator());
        locatorClassDefinitions.put("xpath", new XPathLocator());
        locatorClassDefinitions.put("link_text", new LinkTextLocator());
        locatorClassDefinitions.put("partial_link_text", new PartialLinkTextLocator());
        locatorClassDefinitions.put("tag_name", new TagNameLocator());
        locatorClassDefinitions.put("class_name", new ClassNameLocator());
    }

    public By getLocator(String locatorName, String searchExpression) {
        return locatorClassDefinitions.get(locatorName).by(searchExpression);
    }
}
