package com.yet.spring.module;

public interface FileModule {
    boolean doesSupport(FileExtension type);

    void count();
}
