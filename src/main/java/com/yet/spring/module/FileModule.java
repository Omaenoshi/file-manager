package com.yet.spring.module;

import java.lang.reflect.InvocationTargetException;

public interface FileModule {
    boolean doesSupport(FileExtension type);
    void count();
    void showFunctionDescription();
    void doFunction(int functionNum) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
