package io.github.kuberatest.e2e.action;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ActionManager {

    protected final Map<String, Class<? extends Action>> actionClassDefinitions = new ConcurrentHashMap<>();

    protected ActionManager() {
        Arrays.stream(ActionType.values())
                .forEach(type -> actionClassDefinitions.put(type.getKey(), type.getaClass()));
    }
}
