package io.github.kuberatest.e2e.locate;

import io.github.kuberatest.util.KuberaKey;
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
        locatorClassDefinitions.put(KuberaKey.LOCATOR_ID.getKeyName(), new IdLocator());
        locatorClassDefinitions.put(KuberaKey.LOCATOR_NAME.getKeyName(), new NameLocator());
        locatorClassDefinitions.put(KuberaKey.LOCATOR_CSS_SELECTOR.getKeyName(), new CssSelectorLocator());
        locatorClassDefinitions.put(KuberaKey.LOCATOR_XPATH.getKeyName(), new XPathLocator());
        locatorClassDefinitions.put(KuberaKey.LOCATOR_LINK_TEXT.getKeyName(), new LinkTextLocator());
        locatorClassDefinitions.put(KuberaKey.LOCATOR_PARTIAL_LINK_TEXT.getKeyName(), new PartialLinkTextLocator());
        locatorClassDefinitions.put(KuberaKey.LOCATOR_TAG_NAME.getKeyName(), new TagNameLocator());
        locatorClassDefinitions.put(KuberaKey.LOCATOR_CLASS_NAME.getKeyName(), new ClassNameLocator());
    }

    public By getLocator(String locatorName, String searchExpression) {
        return locatorClassDefinitions.get(locatorName).by(searchExpression);
    }
}
