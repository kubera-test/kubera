package io.github.kuberatest.e2e.testcasereader.excel;

import io.github.kuberatest.e2e.action.Action;
import io.github.kuberatest.e2e.action.ActionManager;

import java.lang.reflect.InvocationTargetException;

public class ExcelActionConverter extends ActionManager {
    private static ExcelActionConverter instance;

    public static synchronized ExcelActionConverter getInstance() {
        if (instance == null) {
            instance = new ExcelActionConverter();
        }
        return instance;
    }

    public Action convert(ExcelActionData excelActionData) {
        Action action;
        try {
            action = actionClassDefinitions.get(excelActionData.getActionKey()).getDeclaredConstructor().newInstance();
        // TODO: 例外の実装
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        action.setFromExcel(excelActionData);
        return action;
    }
}
