package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.InvocationTargetException;

public abstract class FileModule {
    private final FileExtension[] supportedExtensions;
    private final String[] functionDescription;

    protected FileModule(FileExtension[] supportedExtensions, String[] functionDescription) {
        this.supportedExtensions = supportedExtensions;
        this.functionDescription = functionDescription;
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
    public abstract void doFunction(int functionNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
