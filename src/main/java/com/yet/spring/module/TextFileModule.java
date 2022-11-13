package com.yet.spring.module;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;

@Component
public class TextFileModule implements FileModule {

    private static final FileExtension[] SUPPORTED_TYPES = {FileExtension.TXT};

    @Override
    public boolean doesSupport(FileExtension type) {
        return ArrayUtils.contains(SUPPORTED_TYPES, type);
    }

    @Override
    public void count() {

    }
}
