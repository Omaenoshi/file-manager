package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class FileModule {
    private final FileExtension[] supportedExtensions;
    private final String[] functionDescription;
    private final Map<Integer, String> functionNames;

    protected FileModule(FileExtension[] supportedExtensions, String[] functionDescription, Map<Integer, String> functionNames) {
        this.supportedExtensions = supportedExtensions;
        this.functionDescription = functionDescription;
        this.functionNames = functionNames;
    }

    public boolean doesSupport(FileExtension type) {
        return ArrayUtils.contains(supportedExtensions, type);
    }
    public void showFunctionDescription() {
        for (String line:
                functionDescription) {
            System.out.println(line);
        }
    }
    public void doFunction(int functionNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        Class<? extends FileModule> clazz = this.getClass();
        Method method = clazz.getDeclaredMethod(functionNames.get(functionNum));
        method.setAccessible(true);
        method.invoke(clazz);
    }
}
